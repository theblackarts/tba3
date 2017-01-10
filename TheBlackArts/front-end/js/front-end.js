function dragstart_handler(ev) {
 ev.preventDefault();
 // Add the target element's id to the data transfer object
 ev.dataTransfer.setData("text/plain", ev.target.id);
 ev.dropEffect = "move";
}
function drop_handler(ev) {
 ev.preventDefault();
 // Get the id of the target and add the moved element to the target's DOM
 var data = ev.dataTransfer.getData("text");
 ev.target.appendChild(document.getElementById(data));
}