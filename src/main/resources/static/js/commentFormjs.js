let button = document.getElementById("comment");
let commentForm = document.getElementById("commentForm");
button.addEventListener("click", (e) =>{
    e.preventDefault();
    commentForm.innerHTML = "<div class=\"form-group\">\n" +
        "    <div class=\"form-group\">\n" +
        "    <label for=\"comment\">comment:</label>\n" +
        "    <textarea class=\"form-control\" rows=\"4\" cols=\"50\" id=\"comment\" th:field=\"*{comment}\"></textarea>\n" +
        "    <br/>\n" +
        "    </div>\n" +
        "    <input type=\"submit\"/>"
});


// <form th:object='${comment}' th:action='|/comment/${Post.id}|' th:method='post' sec:authorize='isAuthenticated()'>\n" +
//     "<div class='form-group'>\n" +
//     "    <div class='form-group'>\n" +
//     "    <label for='comment'>comment:</label>\n" +
//     "    <textarea class='form-control' rows='4' cols='50' id='comment' th:field='*{comment}'></textarea>\n" +
//     "    <br/>\n" +
//     "    </div>\n" +
//     "    <input type='submit' formaction='/comment/create' formmethod='post'/> </div> </form>"