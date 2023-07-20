function getCookieExpires(cookName,cookValue,cookName2,cookValue2,expDate) {
    let now = new Date();
    now.setDate(now.getDate() + Number(expDate));
    let myCookie = "";
    myCookie = `${cookName}=${cookValue};${cookName2}=${cookValue2};expires=` + now.toUTCString();
    console.log(myCookie);
    document.cookie = myCookie; // 쿠키 저장
}