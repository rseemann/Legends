package SheetGUI;

public interface IListenable {
	public void addListener(IListener listener);
	public void notifyListener();
}
