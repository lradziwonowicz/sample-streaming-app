var messagesArray = [
	{ text: "Some msg..." },
	{ text: "Other msg..." },
	{ text: "Some content..." }
];


// Overall viewmodel for this screen, along with initial state
var viewModel = {
	messages: ko.observableArray(messagesArray),
	
	addMessage: function(msg){
		this.messages.unshift(msg);
	}
};

ko.applyBindings(viewModel);

var socket = new WebSocket("ws://localhost:9000/stream");

var msg = {};
socket.onmessage = function(event){
	msg = { text: event.data };
	viewModel.addMessage(msg);
}