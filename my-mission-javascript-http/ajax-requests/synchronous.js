var http = new XMLHttpRequest();
http.open("GET", "https://jsonplaceholder.typicode.com/posts/1", true);
http.send();
http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
        console.log(JSON.parse(http.response));
    }
};

console.log("Start Synchronous FINISHED!!");