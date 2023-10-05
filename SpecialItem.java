public class SpecialItem {
    private String item;
    private int delay;
    private String textColor;

    public SpecialItem(String item, int delay, String textColor) {
        this.item = item;
        this.delay = delay;
        this.textColor = textColor;
    }

    public String getItem() {
        return item;
    }

    public int getDelay() {
        return delay;
    }

    public String getTextColor() {
        return textColor;
    }
}
