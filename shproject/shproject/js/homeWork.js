function getCookieExpires(cookName,cookValue,expDate) {
    let now = new Date();
    now.setDate(now.getDate() + Number(expDate));
    let myCookie = "";
    myCookie = `${cookName}=${cookValue};expires=` + now.toUTCString();
    console.log(myCookie);
    document.cookie = myCookie; // 쿠키 저장
}