package by.htp.equipment;

public abstract class Equipment {
	protected Category category;
	protected String title;
	protected static int counterForID;
	protected final int id;

	{
		counterForID++;
	}

	public Equipment(Category category, String title) {
		this.category = category;
		this.title = title;
		id = counterForID;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Equipment [category=" + category + ", title=" + title + ", id=" + id + "]";
	}

}
