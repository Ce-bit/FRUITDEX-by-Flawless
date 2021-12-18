package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.databinding.CatalogListBinding;

import java.util.ArrayList;

public class CatalougeActivity extends AppCompatActivity {

    CatalogListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CatalogListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.akee,R.drawable.almond,R.drawable.avocado,R.drawable.banana,R.drawable.barbadine,
                R.drawable.breadfruit,R.drawable.cantaloupe,R.drawable.carillie,R.drawable.cashew,R.drawable.chalta,R.drawable.chatigne,R.drawable.chenet,R.drawable.chinese_tamarind,
                R.drawable.christophene,R.drawable.cocoa,R.drawable.custardapple,R.drawable.fatpork,R.drawable.governor_plum,R.drawable.grapefruit,R.drawable.guava,R.drawable.jackfruit,
                R.drawable.lime,R.drawable.lychee,R.drawable.mandarin,R.drawable.mango,R.drawable.mircale_fruit,R.drawable.noni,R.drawable.pawpaw,R.drawable.peewah,
                R.drawable.pommecythere,R.drawable.pommerac,R.drawable.patrick_starmie};
        String[] name = {"Akee","Almond","Avocado","Banana","Barbadine","Breadfruit","Cantaloupe","Carillie","Cashew","Chalta","Chatigne","Chenet","Chinese Tamarind",
                         "Christophene","Coca","Custard Apple", "Fat Pork","Governor Plum", "Grapefruit","Guava","Jackfruit","Lime","Lychee","Mandarin","Mango","Miracle Fruit",
                         "Noni","PawPaw","Peewah","Pommecythere","Pommerac","Star Fruit"};
        String[] lastMessage = {"Prunus amygdalus","Prunus amygdalus","Lauraceae","Passiflora","Passiflora","Moraceae","Cucurbitaceae","Cucurbitaceae","Anacardium Occidentale","Dillenia","Moraceae","Sapindaceae","Rubiaceae",
                "Guord","Erythroxylaceae","Annonaceae", "Chrysobalanaceae","Governor Plum", "Salicaceaet","Psidium guajava","Mulberry","Rutaceae","Soapberry","Rutaceae","Anacardiaceae","Sapotaceae",
                "Madder","Custard apples","Palm","Pommecythere","Anacardiaceae","Averrhoa carambola"};
        String[] lastmsgTime = {"Akee","Almond","Avocado","Banana","Barbadine","Breadfruit","Cantaloupe","Carillie","Cashew","Chalta","Chatigne","Chenet","Chinese Tamarind",
                "Christophene","Coca","Custard Apple", "Fat Pork","Governor Plum", "Grapefruit","Guava","Jackfruit","Lime","Lychee","Mandarin","Mango","Miracle Fruit",
                "Noni","PawPaw","Peewah","Pommecythere","Pommerac","Star Fruit"};
        String[] phoneNo = {"ankye, achee, akee, ackee apple",
                            "tropical almond, beach almond",
                            "Zaboca",
                            "cooking fig, chiquito or soucrier or sikiye fig, Gros Michel, moko, plantain, silk fig, and more.",
                            "giant granadilla, grenadine",
                            "No other names",
                            "No other names",
                            "Bitter Melon",
                            "No other names",
                            "Elephant Apple",
                            "Breadnut, katahar ",
                            "chenette, chennet, quenepa, guinep, Spanish lime",
                            "Spanish tamarind, tamarind dayza",
                            "Chayote",
                            "Cacao",
                            "No other names",
                            "fat poke, coco plum, paradise plum, icaco",
                            "jocote",
                            "No other names",
                            "No other names",
                            "cowah",
                            "No other names",
                            "No other names",
                            "No other names",
                            "No other names",
                            "Miracle berry",
                            "great morinda, Indian mulberry, cheese fruit",
                            "Papaya",
                            "Palm Fruit",
                            "No other names",
                            "pommerac, Jamaican apple, Otaheite apple, Malay rose apple, mountain apple",
                            "Five Finger, Cosmic Fruit, Patrick"};
        String[] country = {"The ackee, also known as ankye, achee, akee, ackee apple or ayee is a fruit of the Sapindaceae family, as are the lychee and the longan. It is native to tropical West Africa.",
                            "The fruit of the almond is a drupe, consisting of an outer hull and a hard shell with the seed, which is not a true nut, inside. Shelling almonds refers to removing the shell to reveal the seed. Names: tropical almond, beach almond.",
                            "The is botanically a large berry containing a single large seed and buttery flesh. Names: Zaboca ",
                            "A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. ",
                            "Passiflora quadrangularis, the giant granadilla, barbadine, grenadine, giant tumbo or badea, is a species of plant in the family Passifloraceae. It produces the largest fruit of any species within the genus Passiflora. It is a perennial climber native to the Neotropics. ",
                            "Breadfruit is a species of flowering tree in the mulberry and jackfruit family believed to be a domesticated descendant of Artocarpus camansi originating in New Guinea, the Maluku Islands, and the Philippines.",
                            "The cantaloupe is a melon that is a variety of the muskmelon species from the family Cucurbitaceae.",
                            "Momordica charantia is a tropical and subtropical vine of the family Cucurbitaceae, widely grown in Asia, Africa, and the Caribbean for its edible fruit. Its many varieties differ substantially in the shape and bitterness of the fruit.",
                            "The cashew tree is a tropical evergreen tree that produces the cashew seed and the cashew apple accessory fruit.",
                            "The elephant apple, is a species of Dillenia native to China and tropical Asia.",
                            "Chataigne is a large fruit with thorny green skin and many seeds. It is the seeded and wild ancestor of breadfruit.",
                            "Ovoid green fruit that grows in bunches on trees up to 30m high. The fruit typically ripen during the summer. The fruit is related to the lychee and have tight, thin but rigid skins. Inside the skin is the tart, tangy, or sweet pulp of the fruit covering a large seed. The pulp is usually cream or orange coloured.",
                            "It is a small to medium size African fruit that is eaten after it ripens and dries on the tree and tastes something like dried apples.",
                            "Edible pear shaped green vegetable of the squash family. The vegetable bears on vines and comes in smooth skinned and prickly skinned varieties. It is typically eaten boiled or in soups.",
                            "The cocoa bean or simply cocoa, also called the cacao bean or cacao, is the dried and fully fermented seed of Theobroma cacao, from which cocoa solids and cocoa butter can be extracted.",
                            "The sugar-apple or sweet-sop is the fruit of Annona squamosa, the most widely grown species of Annona and a native of tropical climate in the Americas and West Indies.",
                            "It is a small and circular fruit and often has red skin when ripe. The flesh is white, sweet, and mild.",
                            "Governor plum is a small fruit that tend to be oddly shaped with little knobbed parts. The fruit contains a large seed, surrounded by yellow flesh.",
                            "The grapefruit is a subtropical citrus tree known for its relatively large, sour to semi-sweet, somewhat bitter fruit.",
                            "Guava is a common tropical fruit cultivated in many tropical and subtropical regions.",
                            "Jackfruit is enormous and prickly on the outside. It is oblong, green, and looks somewhat like durian.",
                            "A lime is a citrus fruit, which is typically round, green in color, and contains acidic juice.",
                            "Lychee is a small, oval to roundish fruit of a Chinese tree (Litchi chinensis) of the soapberry family having a rough or warty, yellow, pink, or reddish leathery rind and sweet to slightly acidic usually whitish edible flesh that surrounds a single large seed. Lychee is similar to Rambutan.",
                            "Mandarin is a group name for a class of oranges with thin, loose peel.",
                            "Mangoes contain one large seed surrounded by yellow, juicy, delicious flesh and have a wide range of varieties. Varieties include doux doux, calabash, cutlass, Graham, hog, horse, Julie, long, rose, spice and starch mango.",
                            "The berry has a mildly sweet flavor. The fruit’s juice acts as a sweetness inducer when it meets acids, causing bitter and sour foods to taste sweet, temporarily. This effect usually lasts between 30 minutes and 2 hours.",
                            "Noni is a small evergreen tree found in the Pacific Islands, Southeast Asia, Australia, and India. It has a strong scent similar to that of vomit.",
                            "Pawpaw is a soft tropical fruit with a yellowish-orange color. This species of fruit is round and plump and comes in larger and smaller sizes.",
                            "The fruit of this palm looks like a mini-coconut. It has a thin skin, orange flesh and a single seed at the center. Peewah must be boiled to be edible and has a unique, starchy taste.",
                            "It has green skin and an oval shape. The interior has a pale green to pale yellow to a yellow pulp (depending on how ripe the fruit is) that surrounds one spiny seed.",
                            "Pomerac is a tropical fruit that is pear-shaped, red to dark red in color when ripe, and contains a single large seed surrounded by white flesh that has a softer, spongier texture than an apple.",
                            "The Cosmic Star fruit is a sweet and sour fruit that has the shape of a five-point star. The skin is edible and the flesh has a mild, sour flavor that makes it popular in a number of dishes. Learns Hydro Pump at level 69."};

        ArrayList<Fruit> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            Fruit user = new Fruit(name[i],lastMessage[i],lastmsgTime[i]="Local",phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);
        }


        ListAdapter listAdapter = new ListAdapter(CatalougeActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(CatalougeActivity.this,FruitActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}