import telran.messaging.Message;
import telran.messaging.MessageBox;

public class Reciver extends Thread {
	MessageBox messageBox;

	public Reciver(MessageBox messageBox) {
		super();
		this.messageBox = messageBox;

	}

	@Override
	public void run() {
		while (true) {
			try {
				Message message = messageBox.takeMessage();
				if (message.last)
					return;	
				System.out.printf("Thread with id %d: message %s \n", message.id, message.text);
			} catch (InterruptedException e) {
				//
			}

		}

	}
}