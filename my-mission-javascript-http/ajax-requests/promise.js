function get(url) {
    return new Promise(function (resolve, reject) {
        var http = new XMLHttpRequest();
        http.open("GET", url, true);
        http.onload = function () {
            if (http.status == 200) {
                resolve(JSON.parse(http.response));
            } else {
                reject(http.status.Text);
            }
        };
        http.onerror = function () {
            reject(http.statusText);
        };
        http.send();
    });
}

var getData;
var promis = get("https://jsonplaceholder.typicode.com/posts/4");
promis.then(function (data) {
    console.log(data);
    return data;
}).catch(function (error) {
    console.log(error);
});
console.log("Start Promise FINISHED!!");