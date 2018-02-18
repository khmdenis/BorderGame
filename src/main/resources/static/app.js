var stompClient = null;


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#dice_records").html("");
}

function connect() {
    var socket = new SockJS('/game-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        start_game();

        // Next step trigger
        stompClient.subscribe('/process/dice', function (message) {
            showData(message.body);
            current_user();
        });
        // Show current user trigger
        stompClient.subscribe('/process/user', function (message) {
            showData(message.body);
        });

        stompClient.subscribe('/process/game_started', function (message) {
            showData(message.body);
            current_user();
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function start_game() {
    stompClient.send("/app/start_game");
}

function current_user() {
    stompClient.send("/app/curr_user");
}

function dice() {
    stompClient.send("/app/dice");
}

function showData(message) {
    $("#dice_records").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#dice" ).click(function() { dice(); });
});