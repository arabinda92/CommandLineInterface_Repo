import picocli.CommandLine;

/**
 * This is the command class for count pages
 */
@CommandLine.Command(name = "count")
public class CountCommand implements Runnable{
  @Override
  public void run() {
    System.out.println("inside count command");
  }
}
