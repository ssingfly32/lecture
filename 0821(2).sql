-- kmh 스키마를 사용할 것이다.
use kmh;

create table test (
testcol varchar(10));

select * from test;

drop table test;

-- 현재 시간 및 날짜 얻어오는 쿼리문
select now();

-- 멤버 테이블 생성 쿼리문
CREATE TABLE `kmh`.`member` (
  `userId` VARCHAR(8) NOT NULL,
  `userPwd` VARCHAR(500) NOT NULL,
  `userEmail` VARCHAR(50) NULL,
  `registerDate` DATETIME NULL DEFAULT now(),
  `userImg` VARCHAR(50) NULL,
  `userPoint` INT NULL DEFAULT 0,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userEmail_UNIQUE` (`userEmail` ASC) VISIBLE);
  
  -- 포인트 정책(Point Policy) 테이블 생성 쿼리문
  CREATE TABLE `kmh`.`pointpolicy` (
  `why` VARCHAR(50) NOT NULL,
  `howmuch` INT NULL,
  PRIMARY KEY (`why`));
  
  -- 포인트 정책 만들기
  INSERT INTO `pointpolicy` (`why`, `howmuch`) VALUES ('회원가입', '100');
INSERT INTO `pointpolicy` (`why`, `howmuch`) VALUES ('로그인 ', '5');
INSERT INTO `pointpolicy` (`why`, `howmuch`) VALUES ('답글작성', '1');
INSERT INTO `pointpolicy` (`why`, `howmuch`) VALUES ('게시물 작성 ', '2');

-- 포인트 로그(point log) 테이블 생성 쿼리문
CREATE TABLE `kmh`.`pointlog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `when` DATETIME NOT NULL DEFAULT now(),
  `why` VARCHAR(50) NULL,
  `howmuch` INT NULL,
  `who` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`id`));

-- 포인트 로그 테이블 fk 제약조건 추가
ALTER TABLE `kmh`.`pointlog` 
ADD INDEX `pointlog_why_fk_idx` (`why` ASC) VISIBLE,
ADD INDEX `pointlog_who_fk_idx` (`who` ASC) VISIBLE;
;
ALTER TABLE `kmh`.`pointlog` 
ADD CONSTRAINT `pointlog_why_fk`
  FOREIGN KEY (`why`)
  REFERENCES `kmh`.`pointpolicy` (`why`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
ADD CONSTRAINT `pointlog_who_fk`
  FOREIGN KEY (`who`)
  REFERENCES `kmh`.`member` (`userId`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
  
  -- 유저 아이디 중복 검사
  select * from member where userId = 'doo';
  
  -- 회원 테이블에 회원 이미지 기본값 설정
  ALTER TABLE `kmh`.`member` 
CHANGE COLUMN `userImg` `userImg` VARCHAR(50) NULL DEFAULT '/memberImg/user.png' ;

-- 업로드된 파일 처리를 위한 테이블 작성
CREATE TABLE `kmh`.`uploadedfile` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `originalFileName` VARCHAR(50) NOT NULL,
  `ext` VARCHAR(5) NULL,
  `newFileName` VARCHAR(60) NULL,
  `fileSize` VARCHAR(45) NULL,
  PRIMARY KEY (`no`, `originalFileName`));

-- 업로드 파일 처리 테이블에 데이터 추가
INSERT INTO `kmh`.`uploadedfile` (`originalFileName`, `ext`, `newFileName`, `fileSize`) VALUES ('user.png', '.png', 'memberImg/user.png', '17,531');

-- member테이블과 uploadedFile 테이블 관계 설정
ALTER TABLE `kmh`.`member` 
CHANGE COLUMN `userImg` `userImg` INT NULL DEFAULT '1' ;


-- member테이블에서 회원가입 시 포인트 값 100으로 기본 설정
ALTER TABLE `ksh`.`member` 
CHANGE COLUMN `userPoint` `userPoint` INT(11) NULL DEFAULT '100' ;

-- uploadedFile 테이블에 저장하는 insert 쿼리문
insert into uploadedfile(originalFileName, ext, newFileName, fileSize) values(?, ?, ?, ?);

-- 회원 테이블에 insert 하는 쿼리문 (userPwd는 암호화) - 업로드된 이미지가 있을 경우
insert into member(userId, userPwd, userEmail, userImg) values(?, sha1(md5(?)), ?, ?);

-- 회원 테이블에 insert 하는 쿼리문 (userPwd는 암호화) - 업로드된 이미지가 없을 경우
insert into member(userId, userPwd, userEmail) values(?, sha1(md5(?)), ?);

-- 업로드된 파일의 no 찾는 쿼리문
select no from uploadedFile where newFileName = ?;

-- 로그인
select * from member where userId = 'dooly' and userPwd = sha1(md5('1234'));

-- 로그인
select * from member m inner join uploadedfile u on m.userImg = u.no where userId = 'dooly' and userPwd = sha1(md5('1234'));

-- member point 가감
update member set userPoint = userPoint + ? where userId = ?;

select * from member;

use ksh;

-- 관리자 페이지
ALTER TABLE `ksh`.`member` 
ADD COLUMN `isAdmin` VARCHAR(1) NULL DEFAULT 'N' AFTER `userPoint`;

-- BBBB를 Y로;

-- 아이디를 회원 정보로 가져오기
select m.*, u.newFileName from member m inner join uploadedfile u 
on m.userImg = u.no where userId = 'dooly';

-- 회원 포인트 내역 가져오기
select * from pointlog
where who = 'abc123';

-- 답글형 (계층형 게시판 생성)
CREATE TABLE `ksh`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `writer` VARCHAR(8) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `postDate` DATETIME NULL DEFAULT now(),
  `content` VARCHAR(1000) NOT NULL,
  `attachedFile` INT NULL,
  `readcount` INT NULL DEFAULT 0,
  `likecount` INT NULL DEFAULT 0,
  `ref` INT NULL, -- 부모글 
  `step` INT NULL DEFAULT 0,
  `reforder` INT NULL DEFAULT 0,
  PRIMARY KEY (`no`));

-- board 테이블과 member 테이블의 관계설정
ALTER TABLE `ksh`.`board` 
CHANGE COLUMN `writer` `writer` VARCHAR(8) NULL ,
ADD INDEX `board_writer_fk_idx` (`writer` ASC) VISIBLE;
;

-- 회원 탈퇴 시 탈퇴한 회원의 글을 삭제하면 계층형 게시판의 경우 계층 모양이 유지가 되지 않을수도 있으므로 회원 탈퇴 시 writer 컬럼의 값을 null로 만들고,
-- 글 자체는 삭제 되지 않도록 한다.
ALTER TABLE `ksh`.`board` 
ADD CONSTRAINT `board_writer_fk`
  FOREIGN KEY (`writer`)
  REFERENCES `ksh`.`member` (`userId`)
  ON DELETE SET NULL
  ON UPDATE NO ACTION;
  
  -- 게시판에 글 작성하는 쿼리문(단, 첨부 파일이 없을 경우)
  -- ref : no값과 동일한 값이 저장되도록 한다.
  insert into board(writer, title, content, ref)
values('abc123', '게시판이 생성되었습니다.', '자유롭게 글을 남겨주세요', (select auto_increment from information_schema.tables
where table_schema = 'ksh' and table_name = 'board'));

-- 새롭게 글을 작성할 때 ref를 얻어오는 방법(2번째 방법 권장)
select max(no) + 1 as nextref from board;
select auto_increment from information_schema.tables
where table_schema = 'ksh' and table_name = 'board';

-- 게시판에 글 작성하는 쿼리문 (첨부 파일이 있을 경우)
insert into uploadedfile(originalFileName, ext, newFileName, fileSize, boardNo)
values(?, ?, ?, ?,?);

 insert into board(writer, title, content, ref)
 values('bbbb', '아싸 1빠다', '냉무', );

ALTER TABLE `ksh`.`board` 
DROP COLUMN `attachedFile`;

-- 게시판 전체 글 목록 가져오기
select * from board order by no desc;

-- -------------------------------------------------------------------
-- 게시물 상세 조회 
-- ----------------------------------------------------------

-- 조회수 처리를 위한 테이블 생성
CREATE TABLE `ksh`.`readcountprocess` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `ipAddr` VARCHAR(50) NOT NULL,
  `boardNo` INT NOT NULL,
  `readTime` DATETIME NULL,
  PRIMARY KEY (`no`),
  INDEX `rcp_boardNo_fk_idx` (`boardNo` ASC) VISIBLE,
  CONSTRAINT `rcp_boardNo_fk`
    FOREIGN KEY (`boardNo`)
    REFERENCES `ksh`.`board` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--  readCountProcess 테이블에 ip주소와 글번호가 있는지 없는지
select * from readcountprocess where ipAddr = ? and boardNo = ?;

-- ?ip주소가 ?번 글을 읽은 시간이 몇시간 차이인지 검사하는 쿼리문
SELECT TIMESTAMPDIFF(HOUR, (select readTime from readcountprocess where 
ipAddr = ? and boardNo = ?), now()) AS hourDiff; 

-- insert
INSERT INTO `readcountprocess` (`ipAddr`, `boardNo`) VALUES ('?', '?');

-- update
update readcountprocess set readTime = now() where ipAddr = ? and boardNo = ?;

-- no번 글의 조회수 증가하는 쿼리문
update board set readcount = readcount + 1 where no = ?;

-- no번 글을 가져오는 쿼리문
select * from board where no = ?;

-- no번 글에 저장된 파일을 가져오는 
select * from uploadedfile where boardNo = 5;

-- no번 글을 삭제 처리 하는 쿼리문
update board set isDelete = 'Y' where no = ?;

-- -------------------------------------------------------------------
-- 게시물 답글 처리
-- ----------------------------------------------------------
-- * ref : 부모글의 글 번호(8번 글에 달리는 답글의 ref값은 모두 8이다)
-- * step : 답글의 깊이 레벨을 뜻한다. 
-- * reforder : 부모글과 답글들을 정렬할 때 사용될 순서를 의미

-- 1) 부모글(답글이 아닌 글)은 ref 값을 no컬럼의 값과 동일하게 만든다.
-- step = 0, reforder = 0;

-- 2) 게시글을 출력할 때 정렬 기준을 바꿔야 한다.
use ksh;
select * from board order by ref desc, reforder asc;

-- 3) 답글을 board 테이블 등록
-- 3-1) 먼저 답글이 사이에 끼워져야 하는 답글인지 확인하여 끼워져야 하는 답글이라면
-- 아래를 먼저 수행하고
update board set reforder = reforder + 1
where ref = ? and reforder > ?;

-- 3-2) 그리고 답글을 insert 한다.
insert into board(writer, title, content, ref, step, reforder)
values(?, ?, ?, ref, step+1, reforder+1);

-- 3-3) 그 후 나머지 포인트 작업 (update, insert) 해야함.

use ksh;
-- -------------------------------------------------------------------
-- 게시물 조회수 top 5
-- limit [보여주기 시작할 row index 번호], 보여줄 row의 갯수 []: 생략가능!! 
-- -------------------------------------------------------------------
select * from board order by readcount desc limit 5;

-- -------------------------------------------------------------------
-- 페이징 처리
-- -------------------------------------------------------------------
-- 1) limit 키워드를 이용하여 출력할 페이지 수를 제한 할 수 있다.
-- limit [보여주기 시작할 row index 번호], 보여줄 row의 갯수 []: 생략가능!! 
select * from board order by ref desc, reforder asc limit 0, 3;


-- 2) 몇 페이지가 존재하냐?
-- 2-1) 전체 글의 갯수를 구해야 함 : 내 기준 12
select count(*) from board;

-- 2-2) 한 페이지당 몇개의 글을 보여줄 것인가를 결정 : 3
-- 2-3) 총 페이지 수 = 게시판의 글 수 / 한 페이지 당 보여줄 글의 갯수 -> 나누어 떨어지지 않으면 + 1
-- (16 / 3) = 5, 나누어 떨어지지 않았으므로 .. + 1 = 6 페이지 

-- 3) 보여주기 시작할 row index 번호를 구해야 함.
-- 1페이지: limit 0,3
select * from board order by ref desc, reforder asc limit 0, 3;

-- 2페이지 : limit 3,3
select * from board order by ref desc, reforder asc limit 3, 3;

-- 3페이지 : limit 6,3
select * from board order by ref desc, reforder asc limit 6, 3;

-- 4페이지 : limit 9,3
select * from board order by ref desc, reforder asc limit 9, 3;

-- 보여주기 시작할 row index 번호를 구해야 함.
-- 1페이지당 보여줄 글의 갯수 n이라면
-- (현재 페이지번호 -1) * 1페이지당 보여줄 글의 갯수
-- 유저가 클릭한 현재 페이지 번호를 알아야 함. 

-- 1차 페이징 작업 끝-------------------------------------------

-- 2차 페이징 작업 (페이징 블럭 : pagination에 페이지 번호를 몇개씩 출력할 것인가)

-- 1) 1개의 블럭에 몇 개 페이지를 보여줄 것인가(pageCntPerBlock) : 2
-- 전체 페이징 블럭 갯수 = 전체 페이지 수 /  pageCntPerBlock -> 나누어 떨어지지 않으면 + 1

-- 2) 현재 페이지가 속한 페이징 블럭 번호 : 
-- 현재 페이지번호 / pageCntPerBlock -> 나누어 떨어지지 않으면 올림
-- ex) 현재 페이지가 2/ 2 = 1번블럭 

-- 3) 현재 페이징 블럭 시작 페이지 번호 = ((현재 페이징 블럭 번호 - 1) * pageCntPerBlock) + 1

-- 4) 현재 페이징 블럭 끝 페이지 번호 = (현재 페이지 블럭번호) * pageCntPerBlock

