import $ from "jquery";
import uiLite from "ui-lite";

let getTracks = () => {
 $.ajax({
  url: "/api/tracks"
 }).done(function(response) {
  console.log(response);
  var list = $(".list");
  for (let i = 0; i < response.content.length; i++) {
   let track = response.content[i];
   let row = '<div>' + track.name + ' ' + track.author.name + ' ' +
       track.album.name + '</div>';

   list.append(row);
  }
 });
};

getTracks();

window.ui.init();
