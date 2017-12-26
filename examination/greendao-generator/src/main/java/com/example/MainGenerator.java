package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {
        public static void main(String[] args)  throws Exception {

            //place where db folder will be created inside the project folder
            Schema schema = new Schema(1,"database.db");

            //Entity i.e. Class to be stored in the database // ie table LOG
            Entity data_entity= schema.addEntity("images_tbl");

            data_entity.addIdProperty(); //It is the primary key for uniquely identifying a row
            data_entity.addStringProperty("save_string").notNull();  //Not null is SQL constrain
            data_entity.addStringProperty("image_class").notNull();



            //  ./app/src/main/java/   ----   com/codekrypt/greendao/db is the full path
            new DaoGenerator().generateAll(schema, "./app/src/main/java");




        }

}
