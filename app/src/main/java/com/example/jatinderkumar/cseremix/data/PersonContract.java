package com.example.jatinderkumar.cseremix.data;

import android.provider.BaseColumns;

public class PersonContract {
    public static final String PATH_PERSON ="person";
    public static abstract class PersonEntry implements BaseColumns{
        public static final String _ID = "_id";
        public static final String TABLE_NAME ="person";
        public static final String PERSON_NAME ="name";
        public static final String PERSON_PHONE ="phone";
    }
}
