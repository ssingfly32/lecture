function gameStart(user, comp) {
    console.log(user,comp);
    let result ="";
    // user, comp 변수의 값을 비교
    if(user === comp) { // 비긴 경우
        result = "비겼다";
    } else if ((user == 1 && comp == 3) || (user ==2 && comp == 1) || (user == 3 && comp ==2)) { // 이긴 경우
        result = "이겼다";
    } else { // 진 경우
        result = "졌다";
    }
    console.log(user,comp, result);

    // 게임 결과를 반환(현재 함수를 호출한 곳으로 되돌린다.)
    return result;
}