package day10.my_interface;

public interface IWindowsInstaller {
    public void formatWindows(String drive);
    public void installWindows(String version, String productKey);
    public int getLastInstalledWindowsVersion();
}
   