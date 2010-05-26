package Interfaces;

public interface IListenable{
	public void addListener(IListener listener);
	public void clearListener();
	public void notifyListener();
	public void notifyNewCharacter();
}
