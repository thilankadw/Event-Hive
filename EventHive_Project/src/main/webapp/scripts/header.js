/*

-------------login and register----------------

*/

const loginpage = document.getElementById("login-page");
const loginbtn = document.getElementById("loginbtn");
const tologinpagebtn = document.getElementById("registertologin");

const registerpage = document.getElementById("registerpage");
const toregisterpagebtn = document.getElementById("logintiregister");
const signupbtn = document.getElementById("signupbtn");

loginbtn.addEventListener('click', (e) => {
    registerpage.classList.remove("login-page-visible");
    loginpage.classList.add("login-page-visible");
    e.stopPropagation();
});

signupbtn.addEventListener('click', (e) => {
    loginpage.classList.remove("login-page-visible");
    registerpage.classList.add("login-page-visible");
    e.stopPropagation();
});

tologinpagebtn.addEventListener('click', (e) => {
    loginpage.classList.remove("login-page-visible");
    registerpage.classList.add("login-page-visible");
    e.stopPropagation();
});

toregisterpagebtn.addEventListener('click', (e) => {
    registerpage.classList.remove("login-page-visible");
    loginpage.classList.add("login-page-visible");
    e.stopPropagation();
});


document.addEventListener('click', (e) => {
    const targetElement = e.target;

    if(!loginpage.contains(targetElement)){
        if (loginpage.classList.contains("login-page-visible")){
            loginpage.classList.remove("login-page-visible");
        }
        
    }
    if(!registerpage.contains(targetElement)){
		if (registerpage.classList.contains("login-page-visible")){
            registerpage.classList.remove("login-page-visible");
        }
	}
});




  
  