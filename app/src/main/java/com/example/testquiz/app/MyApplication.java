package com.example.testquiz.app;

import android.app.Application;

import com.example.testquiz.models.Question;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {

    //Variable para crear el campo autoincrement
    public static AtomicInteger questionId = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        setUpRealConfig();
        Realm realm = Realm.getDefaultInstance();

        this.questionId = getIdByTable(realm, Question.class);
        realm.close();
    }

    public void setUpRealConfig(){
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    /**
     * Este método generico que extiende de realmobject será nuestro auto_increment
     * @param realm
     * @param anyClass
     * @param <T>
     * @return
     */
    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        //Esta variable tipo object recibe la query  de una clase generica(en este caso la clase Question) que extiende de RealmObject
        RealmResults<T> realmResults = realm.where(anyClass).findAll();
        return (realmResults.size() > 0) ? new AtomicInteger(realmResults.max("id").intValue()) : new AtomicInteger();
    }


}
