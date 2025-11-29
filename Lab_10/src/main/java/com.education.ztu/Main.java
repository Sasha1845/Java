package com.education.ztu;

import com.education.ztu.game.GameEntity;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        GameEntity entity = new GameEntity("Knight", 5, 100, "Sword");

        String filePath = "entity.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(entity);
            System.out.println("Entity serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            GameEntity deserializedEntity = (GameEntity) ois.readObject();
            System.out.println("Deserialized entity: " + deserializedEntity);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
