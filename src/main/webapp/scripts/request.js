export function sendRequest(method, endpoint, body, contentType, callback) {
    let req = new XMLHttpRequest();
    req.addEventListener("load", callback);
    req.open(method, endpoint, true);
    if(contentType != null) {
        req.setRequestHeader("Content-Type", contentType);
    }
    req.send(body);
}