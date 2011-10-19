var messagesArray = [];


// Overall viewmodel for this screen, along with initial state
var viewModel = {
	messages: ko.observableArray(messagesArray),
	
	addMessage: function(msg){
		if(this.messages().length > 10)
			this.messages.pop();
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