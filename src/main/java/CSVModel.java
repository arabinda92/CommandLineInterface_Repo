import java.time.LocalDateTime;
import java.util.Date;

/**
 * Pojo class for CSV data
 */
public class CSVModel {
  private String uuid;
  private String tstamp;
  private String source;
  private String date;
  private String event_type;
  private String event_category;
  private String event_action;
  private String event_label;
  private Long event_value;
  private LocalDateTime created_at;
  private LocalDateTime last_updated_at;
  private String location;

  public CSVModel() {

  }

  public CSVModel(String uuid, String tstamp, String source, String date, String event_type,
                  String event_category, String event_action, String event_label, Long event_value,
                  LocalDateTime created_at, LocalDateTime last_updated_at, String location) {
    this.uuid = uuid;
    this.tstamp = tstamp;
    this.source = source;
    this.date = date;
    this.event_type = event_type;
    this.event_category = event_category;
    this.event_action = event_action;
    this.event_label = event_label;
    this.event_value = event_value;
    this.created_at = created_at;
    this.last_updated_at = last_updated_at;
    this.location = location;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getTstamp() {
    return tstamp;
  }

  public void setTstamp(String tstamp) {
    this.tstamp = tstamp;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getEvent_type() {
    return event_type;
  }

  public void setEvent_type(String event_type) {
    this.event_type = event_type;
  }

  public String getEvent_category() {
    return event_category;
  }

  public void setEvent_category(String event_category) {
    this.event_category = event_category;
  }

  public String getEvent_action() {
    return event_action;
  }

  public void setEvent_action(String event_action) {
    this.event_action = event_action;
  }

  public String getEvent_label() {
    return event_label;
  }

  public void setEvent_label(String event_label) {
    this.event_label = event_label;
  }

  public Long getEvent_value() {
    return event_value;
  }

  public void setEvent_value(Long event_value) {
    this.event_value = event_value;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

  public LocalDateTime getLast_updated_at() {
    return last_updated_at;
  }

  public void setLast_updated_at(LocalDateTime last_updated_at) {
    this.last_updated_at = last_updated_at;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "CSVModel{" +
      "uuid='" + uuid + '\'' +
      ", tstamp=" + tstamp +
      ", source='" + source + '\'' +
      ", date='" + date + '\'' +
      ", event_type='" + event_type + '\'' +
      ", event_category='" + event_category + '\'' +
      ", event_action='" + event_action + '\'' +
      ", event_label='" + event_label + '\'' +
      ", event_value=" + event_value +
      ", created_at=" + created_at +
      ", last_updated_at=" + last_updated_at +
      ", location='" + location + '\'' +
      '}';
  }
}