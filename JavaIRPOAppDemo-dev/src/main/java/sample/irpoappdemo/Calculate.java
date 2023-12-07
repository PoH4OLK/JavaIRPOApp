package sample.irpoappdemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.util.ArrayList;

import static java.util.Collections.min;

public class Calculate {

    private static ItemPg item = new ItemPg();

    static void calculating(float t1, float t2, float dt, int z,
                             ListView listView, ProgressBar pg ,ComboBox cmb) {

        int selectedItem = cmb.getSelectionModel().getSelectedIndex();
        int iteration = 2;
        int w = 1;
        for (; w <= iteration; w += 1) {
            switch (selectedItem) {
                case 0:
                    valueList(t1, t2, dt, z, listView, pg, w, 3.5f, 3.73f, 3);
                    break;
                case 1:
                    valueList(t1, t2, dt, z, listView, pg, w,2.7f, 3.71f, 3.5f);
                    break;
                case 2:
                    valueList(t1, t2, dt, z, listView, pg, w, 3, 3.5f, 3.23f);
                    break;
                case 3:
                    valueList(t1, t2, dt, z, listView, pg, w, 3, 3.43f, 2.7f);
                    break;
                case 4:
                    valueList(t1, t2, dt, z, listView, pg, w, 3.7f, 3.29f, 2.9f);
                    break;
            }
        }
    }

    static float valueList (float t1, float t2, float dt, int ze,
                              ListView listView, ProgressBar pg, int w, float x1, float x2, float x3) {
        ArrayList<Float> nums = new ArrayList();
        ObservableList<String> result = FXCollections.observableArrayList();

        item.setQuantity(0);
        item.quantityProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                pg.progressProperty().bind(item.quantityProperty());
            }
        });

        float z0 = 35;
        float Zpost;
        Zpost = z0;


        if(ze > z0) {
            z0 = z0 + (Zpost + ze);
            for(int i = 2; i <= 5; i += (int)t1) {
                for(int j = 5; j <= 15; j += (int)t2) {
                    for(int q = 20; q <= 50; q += (int)dt) {
                        float value = z0 + x1 * i + x2 * j + x3 * q;
                        nums.add(value);
                        result.add("t1 = " + i + ", " + "t2 = " + j + ", " + "dt = " + q + ", " + "Z[" + w + "] = " + value);
                        listView.setItems(result);
                        item.setQuantity(item.getQuantity() + 0.1);
                    }
                }
            }
        } else if(ze < z0) {
            z0 = z0 - (Zpost - ze);
            for(int i = 2; i <= 5; i += (int)t1) {
                for(int j = 5; j <= 15; j += (int)t2) {
                    for(int q = 20; q <= 50; q += (int)dt) {
                        float value = z0 + x1 * i + x2 * j + x3 * q;
                        nums.add(value);
                        result.add("t1 = " + i + ", " + "t2 = " + j + ", " + "dt = " + q + ", " + "Z[" + w + "] = " + value);
                        listView.setItems(result);
                        item.setQuantity(item.getQuantity() + 0.1);
                    }
                }
            }
        } else {
            for(int i = 2; i <= 5; i += (int)t1) {
                for(int j = 5; j <= 15; j += (int)t2) {
                    for(int q = 20; q <= 50; q += (int)dt) {
                        float value = z0 + x1 * i + x2 * j + x3 * q;
                        nums.add(value);
                        result.add("t1 = " + i + ", " + "t2 = " + j + ", " + "dt = " + q + ", " + "Z[" + w + "] = " + value);
                        listView.setItems(result);
                        item.setQuantity(item.getQuantity() + 0.1);
                    }
                }
            }
        }

        return min(nums);
    }
}
