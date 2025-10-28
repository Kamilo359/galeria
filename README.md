LISTVIEW 

ListView to widok w Androidzie, który wyświetla listę elementów (np. tekstów, obrazków) jeden pod drugim.
Dane do ListView przekazuje Adapter (np. ArrayAdapter).


Przykład:

xml
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />

java
String[] owoce = {"Jabłko", "Banan", "Gruszka"};
ArrayAdapter<String> adapter = new ArrayAdapter<>(
    this,
    android.R.layout.simple_list_item_1,
    owoce
);
listView.setAdapter(adapter);
