package telran.messaging;

public class MessageBox {
	Message  message = new Message(null,false);
	public synchronized Message takeMessage() throws InterruptedException {
		while (message.text == null) {
			wait();
		}
		String text = message.text;
		if (!message.last) {
			message.text = null;
		}

		notifyAll();
		return new Message(text,message.last);
	}

	public synchronized void putMessage(Message message) throws InterruptedException {
		while (this.message.text != null) {
			wait();
		}
		this.message = message;
		notifyAll();
	}

}
