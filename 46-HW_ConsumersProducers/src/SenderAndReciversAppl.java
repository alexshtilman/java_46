import telran.messaging.MessageBox;

public class SenderAndReciversAppl {

	private static final int N_RECEIVERS = 10;
	private static final int N_MESSAGES = 20;

	public static void main(String[] args) throws InterruptedException {
		MessageBox messageBox = new MessageBox();
		Sender sender = new Sender(messageBox);
		sender.setnMessages(N_MESSAGES);
		for(int i = 0; i < N_RECEIVERS; i++) {
			new Reciver(messageBox).start();
		}
		sender.start();
		sender.join();
	}

}