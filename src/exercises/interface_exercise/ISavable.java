package exercises.interface_exercise;

import java.util.List;

public interface ISavable {

    List<String> write();
    void read(List<String> savedValues);

}
