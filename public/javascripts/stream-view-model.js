var messagesArray = [
	{ text: "Some msg..." },
	{ text: "Other msg..." },
	{ text: "Some content..." }
];


// Overall viewmodel for this screen, along with initial state
var viewModel = {
	messages: ko.observableArray(messagesArray),
	
	addMessage: function(text){
		this.messages.push(text);
	}
};

ko.applyBindings(viewModel);

var socket = new WebSocket("ws://localhost:9000/stream");

socket.onmessage = function(event){
	viewModel.addMessage(event.data);
}