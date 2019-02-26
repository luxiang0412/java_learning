package luxiang.top;

public enum Color {
    RED("（红色）",0), GREEN("（绿色）", 1), BLANK("（白色）", 2), YELLO("（黄色）", 3);
    private String name;
    private int index;
    private Color(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static Color getColorByName(String name){
        for (Color e:values()){
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public static String getName(int index){
        return values()[index].name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
