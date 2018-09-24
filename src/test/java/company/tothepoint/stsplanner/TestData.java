package company.tothepoint.stsplanner;

import company.tothepoint.stsplanner.model.Pointer;
import company.tothepoint.stsplanner.model.Preference;
import company.tothepoint.stsplanner.model.Room;
import company.tothepoint.stsplanner.model.Topic;

import java.util.Arrays;
import java.util.List;

public class TestData {
  public static final Pointer NICK = Pointer.builder()
      .firstName("Nick")
      .lastName("Vermeylen")
      .build();
  public static final Pointer KAJ = Pointer.builder()
      .firstName("Kaj")
      .lastName("Van der Hallen")
      .build();
  public static final Pointer KOEN = Pointer.builder()
      .firstName("Koen")
      .lastName("Van Loock")
      .build();
  public static final Pointer ARNE = Pointer.builder()
      .firstName("Arne")
      .lastName("Adriaenssens")
      .build();
  public static final Pointer TIMOTHY = Pointer.builder()
      .firstName("Timothy")
      .lastName("Van Wichelen")
      .build();
  public static final Pointer JOHAN = Pointer.builder()
      .firstName("Johan")
      .lastName("Siebens")
      .build();

  public static final Room ROOM_1 = Room.builder()
      .capacity(3)
      .name("Room 1")
      .build();

  public static final Room ROOM_2 = Room.builder()
      .capacity(5)
      .name("Room 2")
      .build();

  public static final Topic KAJS_TALK = Topic.builder()
      .speaker(KAJ).subject("Reactive Pi's")
      .build();

  public static final Topic KOENS_TALK = Topic.builder()
      .speaker(KOEN).subject("The art of the State")
      .build();

  public static List<Pointer> fivePointers() {
    return Arrays.asList(
        KAJ,
        NICK,
        ARNE,
        TIMOTHY,
        JOHAN
    );
  }

  public static List<Preference> allWantKajsTalk() {
    return Arrays.asList(
        Preference.builder()
            .pointer(NICK)
            .build(),
        Preference.builder()
            .pointer(ARNE)
            .build(),
        Preference.builder()
            .pointer(TIMOTHY)
            .build(),
        Preference.builder()
            .pointer(JOHAN)
            .build()
    );
  }
}
