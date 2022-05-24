/**
title : 정규식 검사
 */
// ID 정규식 검사
const isId = function(asValue){
	// 영문자로 시작하는 영문자 또는 숫자 4~20자
	const regExp = /^[a-z]+[a-z0-9]{4,19}$/g;
	 
	return regExp.test(asValue);
};

// PASSWORD 정규식 검사
const isPwd = function(asValue){
	// 최소 4 자, 하나 이상의 문자와 하나의 숫자
	var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$/g;
	 
	return regExp.test(asValue);
}