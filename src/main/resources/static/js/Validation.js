$(window).on('load',function(){
    $('#passwordError').modal('show');
    $('#usernameError').modal('show');
    $('#emailError').modal('show');
    $('#Both').modal('show');
});
let yes = document.getElementById("yes");
yes.addEventListener('click', (e) =>{
    e.preventDefault();
    location="/login";

})