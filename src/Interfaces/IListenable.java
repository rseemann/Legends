package Interfaces;

public interface IListenable{
	public void addListener(IListener listener);
	public void notifyListener();
	public void notifyNewCharacter();
}
