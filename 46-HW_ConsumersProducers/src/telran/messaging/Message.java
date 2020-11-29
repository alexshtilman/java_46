package telran.messaging;

public 	class Message{
	public String text;
	public boolean last = false;
	public long id;
	public Message(String text, boolean last) {
		this.text = text;
		this.last = last;
		this.id = Thread.currentThread().getId();
	}

}
