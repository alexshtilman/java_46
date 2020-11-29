import telran.messaging.Message;
import telran.messaging.MessageBox;

public class Sender extends Thread {
	MessageBox messageBox;
	private int nMessages = 20;

	public int getnMessages() {
		return nMessages;
	}

	public void setnMessages(int nMessages) {
		this.nMessages = nMessages;
	}

	public Sender(MessageBox messageBox) {
		super();
		this.messageBox = messageBox;
	}

	@Override
	public void run() {
		for (int i = 1; i <= nMessages; i++) {
			try {
				messageBox.putMessage(new Message("" + i, false));
			} catch (InterruptedException e) {
				// ok
			}
		}
		try {
			messageBox.putMessage(new Message("" + nMessages, true));
		} catch (InterruptedException e) {
			// ok
		}
	}
}