/**
 *  회원가입 페이지
 */
 /* 함수 호출 */
 $(() => {
	 fnCheckEmail();
	 fnJoin();
 })
 /* 전역 변수 선언 */
 var emailPassed = false;
 
 
 /* 함수 정의 */
 const getContextPath = () => {
  let begin = location.href.indexOf(location.host) + location.host.length;
  let end = location.href.indexOf('/', begin + 1);
  return location.href.substring(begin, end);
 }
 const fnCheckEmail = () => {
  $('#btn_get_code').click(() => {
	  
	let email = $('#email').val();
	
	// 연속된 ajax() 함수 호출의 살행 순서를 보장하는 JavaScript 객체 Promise
	new Promise((resolve, reject) => {
	  // 성공했다면 resolve() 함수 호출 -> then() 메서드에 정의된 화살표 함수 호출
	  // 실패했다면 reject() 함수 호출 -> catch() 메서드에 정의된 화살표 함수 호출
	  
	  // 1. 정규식 검사
	  let regEmail = /^[A-Za-z0-9-_]+@[A-Za-z0-9]{2,}([.][A-Za-z]{2,6}){1,2}$/;
	  if(!regEmail.test(email)) {
		reject(1);
		return;
	  }
	  
	  // 2. 이메일 중복 체크
	  $.ajax({
		 // 요청
		 type: 'get',
		 url: getContextPath() + '/user/checkEmail.do',
		 data: 'email=' + email, 
		 // 응답
		 dataType: 'json',
		 success: (resData) => { // resData === {"enableEmail" : true}
		  if(resData.enableEmail){
			resolve();
		  } else {
			reject(2);
		  }
		 }
	  })
	}).then(() => {
		
	  // 3. 인증 코드 전송
	  $.ajax({
		// 요청
		type: 'get',
		url: getContextPath() + '/user/sendCode.do',
		data: 'email=' + email, 
		// 응답
		dataType: 'json',
		success: (resData) => {  // resData === {"code": "6자리코드"}
		alert(email + "로 인증코드를 전송했습니다.");
		$('#code').prop('disabled', false);
		$('#btn_verify_code').prop('disabled', false);
		 $('#btn_verify_code').click(() => {
		   emailPassed = $('#code').val() === resData.code;
		   if(emailPassed){
			  alert('이메일이 인증되었습니다.');
		   } else {
			  alert('이메일 인증이 실패했습니다.');
		   }
		 })
		}
	  })
	  
	}).catch((state) => {
		emailPassed = false;
	   switch(state){
	   case 1: $('#msg_email').text('이메일 형식이 올바르지 않습니다'); break;
	   case 2: $('#msg_email').text('이미 가입한 이메일 입니다. 다른 이메일을 입력해주세요.'); break;	   
	   }
	})
  })
 }
 
  const fnJoin = (ev) => {
    $('#frm_join').submit((ev) => {
      if(!emailPassed) {
    	alert('이메일을 인증 받아야 합니다.');
    	ev.preventDefault();
    	return;
      }   
    })
  }
 