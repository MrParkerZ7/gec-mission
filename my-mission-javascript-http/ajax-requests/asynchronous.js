$.get("https://jsonplaceholder.typicode.com/posts/2", function (data) {
    console.log(data);
});
$.ajax({
    type: "GET",
    url: "https://jsonplaceholder.typicode.com/posts/3",
    // url: "data/user.json",
    success: function (data) {
        console.log(data);
    },
    error: function (jqXHR, textStatus, error) {
        console.log(error);
    }
});
console.log("Start Asynchronous FINISHED!!");