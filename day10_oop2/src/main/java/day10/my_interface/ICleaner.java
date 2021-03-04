package day10.my_interface;

public interface ICleaner {
    public void setTools(String toolName);
    public void clean(String building, String roomName);
    public String[] getCleanedRoom();
}
   