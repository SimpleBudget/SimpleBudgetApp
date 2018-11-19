let button = document.getElementById("show");
let commentForm = document.getElementById("commentForm");
button.addEventListener("click", (e) => {
    e.preventDefault();
    commentForm.style.display = "block";
    button.style.display = "none";
});
let editForm = Array.from(document.getElementsByClassName("editForm"));
let editComment = Array.from(document.getElementsByClassName("editComment"));
let showreply = Array.from(document.getElementsByClassName("showReply"));
let replyForm = Array.from(document.getElementsByClassName("replyForm"));
let editReplyForm = Array.from(document.getElementsByClassName("editReplyForm"));
let editReply = Array.from(document.getElementsByClassName("editReply"));


showreply.forEach((element, index)=>{
    element.addEventListener("click", (e) => {
        e.preventDefault();
        button.style.display = "none";
        replyForm[index].style.display = "block";
    });
});
editComment.forEach((element, index) =>{
    element.addEventListener("click", (e) =>{
        e.preventDefault();
        editForm[index].style.display = "block";
    });

});
editReply.forEach((element, index) =>{
    element.addEventListener("click", (e) =>{
        e.preventDefault();
        editReplyForm[index].style.display = "block";
    });

});