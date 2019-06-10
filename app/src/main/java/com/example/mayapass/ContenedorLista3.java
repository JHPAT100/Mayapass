package com.example.mayapass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayapass.adaptador.AdaptadorLeyendas;
import com.example.mayapass.adaptador.AdaptadorMitos;
import com.example.mayapass.clases.LeyendasV;
import com.example.mayapass.clases.MitosV;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContenedorLista3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContenedorLista3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenedorLista3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerLeyendas;
    ArrayList<LeyendasV> listaLeyendas;

    public ContenedorLista3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorLista3.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenedorLista3 newInstance(String param1, String param2) {
        ContenedorLista3 fragment = new ContenedorLista3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_contenedor_lista3, container, false);
        listaLeyendas=new ArrayList<>();
        recyclerLeyendas= (RecyclerView) vista.findViewById(R.id.listaLeyendas);
        recyclerLeyendas.setLayoutManager(new LinearLayoutManager(getContext()));
        listLeyendas();
        AdaptadorLeyendas adapter=new AdaptadorLeyendas(listaLeyendas);
        recyclerLeyendas.setAdapter(adapter);
        return vista;
    }

    private void listLeyendas(){

        listaLeyendas.add(new LeyendasV("Dziú y el maíz","La leyenda se centra en Dziú, un pájaro que fue reconocido por su valentía.","Cuenta la leyenda que el Dios del agua y el Dios del fuego querían incendiar los cultivos para tener tierras fértiles e iniciar desde cero… “una mañana, Chaac, el Señor de la Lluvia, sintió deseos de pasear y quiso recorrer los campos de El Mayab. Chaac salió muy contento, seguro de que encontraría los cultivos fuertes y crecidos, pero apenas llegó a verlos, su sorpresa fue muy grande, pues se encontró con que las plantas estaban débiles y la tierra seca y gastada. Al darse cuenta de que las cosechas serían muy pobres, Chaac se preocupó mucho. Luego de pensar un rato, encontró una solución: quemar todos los cultivos, así la tierra recuperaría su riqueza y las nuevas siembras serían buenas\n" +
                    "Después de tomar esa decisión, Chaac le pidió a uno de sus sirvientes que llamara a todos los pájaros de El Mayab. El primero en llegar fue el dziú, un pájaro con plumas de colores y ojos cafés. Apenas se acomodaba en una rama cuando llegó a toda prisa el toh, un pájaro negro cuyo mayor atractivo era su larga cola llena de hermosas plumas. El toh se puso al frente, donde todos pudieran verlo.\n" +
                    "Poco a poco se reunieron las demás aves, entonces Chaac les dijo:\n" +
                    "—Las mandé llamar porque necesito hacerles un encargo tan importante, que de él depende la existencia de la vida. Muy pronto quemaré los campos y quiero que ustedes salven las semillas de todas las plantas, ya que esa es la única manera de sembrarlas de nuevo para que haya mejores cosechas en el futuro. Confío en ustedes; váyanse pronto, porque el fuego está por comenzar.\n" +
                    "En cuanto Chaac terminó de hablar el pájaro dziú pensó:\n" +
                    "—Voy a buscar la semilla del maíz; yo creo que es una de las más importantes para que haya vida.\n" +
                    "Y mientras, el pájaro toh se dijo:\n" +
                    "—Tengo que salvar la semilla del maíz, todos me van a tener envidia si la encuentro yo primeroAsí, los dos pájaros iban a salir casi al mismo tiempo, pero el toh vio al dziú y quiso adelantarse; entonces se atravesó en su camino y lo empujó para irse él primero. Al dziú no le importó y se fue con calma, pero muy decidido a lograr su objetivo.\n" +
                    "El toh voló tan rápido, que en poco tiempo ya les llevaba mucha ventaja a sus compañeros. Ya casi llegaba a los campos, pero se sintió muy cansado y se dijo:\n" +
                    "—Voy a descansar un rato. Al fin que ya voy a llegar y los demás todavía han de venir lejos.\n" +
                    "Entonces, el toh se acostó en una vereda. Según él sólo iba a descansar pero se durmió sin querer, así que ni cuenta se dio de que ya empezaba a anochecer y menos de que su cola había quedado atravesada en el camino. El toh ya estaba bien dormido, cuando muchas aves que no podían volar pasaron por allí y como el pájaro no se veía en la oscuridad, le pisaron la cola.\n" +
                    "Al sentir los pisotones, el toh despertó, y cuál sería su sorpresa al ver que en su cola sólo quedaba una pluma. Ni idea tenía de lo que había pasado, pero pensó en ir por la semilla del maíz para que las aves vieran su valor y no se fijaran en su cola pelona.\n" +
                    "Mientras tanto, los demás pájaros ya habían llegado a los cultivos. La mayoría tomó la semilla que le quedaba más cerca, porque el incendio era muy intenso. Ya casi las habían salvado todas, sólo faltaba la del maíz. El dziú volaba desesperado en busca de los maizales, pero había tanto humo que no lograba verlos. En eso, llegó el toh, cuando vio las enormes llamas, se olvidó del maíz y decidió tomar una semilla que no ofreciera tanto peligro. Entonces, voló hasta la planta del tomate verde, donde el fuego aún no era muy intenso y salvó las semillas.\n" +
                    "En cambio, al dziú no le importó que el fuego le quemara las alas; por fin halló los maizales, y con gran valentía, fue hasta ellos y tomó en su pico unos granos de maíz.\n" +
                    "El toh no pudo menos que admirar la valentía del dziú y se acercó a felicitarlo. Entonces, los dos pájaros se dieron cuenta que habían cambiado: los ojos del toh ya no eran negros, sino verdes como el tomate que salvó, y al dziú le quedaron las alas grises y los ojos rojos, pues se acercó demasiado al fuego.\n" +
                    "Chaac y las aves supieron reconocer la hazaña del dziú, por lo que se reunieron para buscar la manera de premiarlo. Y fue precisamente el toh, avergonzado por su conducta, quien propuso que se le diera al dziú un derecho especial:\n" +
                    "—Ya que el dziú hizo algo por nosotros, ahora debemos hacer algo por él. Yo propongo que a partir de hoy, pueda poner sus huevos en el nido de cualquier pájaro y que prometamos cuidarlos como si fueran nuestros”.\n" +
                    "Y es así como ahora las aves cumplen su promesa y cuidan las crías de dziú.", R.drawable.leyenda1));


            listaLeyendas.add(new LeyendasV("El Chom","La leyenda cuenta la historia de los pájaros llamados Chom y del castigo impuesto para éstos por parte del Rey de Uxmal.","Cuenta la leyenda que en Uxmal, una de las ciudades más importantes de El Mayab, vivió un rey al que le gustaban mucho las fiestas. Un día, se le ocurrió organizar un gran festejo en su palacio para honrar al Señor de la Vida, llamado Hunab ku, y agradecerle por todos los dones que había dado a su pueblo.\n" +
                    "El rey de Uxmal ordenó con mucha anticipación los preparativos para la fiesta. Además invitó a príncipes, sacerdotes y guerreros de los reinos vecinos, seguro de que su festejo sería mejor que cualquier otro y que todos lo envidiarían después. Así, estuvo pendiente de que su palacio se adornara con las más raras flores, además de que se prepararan deliciosos platillos con carnes de venado y pavo del monte. Y no podía faltar el balché, un licor embriagante que le encantaría a los invitados.\n" +
                    "Por fin llegó el día de la fiesta. El rey de Uxmal se vistió con su traje de mayor lujo y se cubrió con finas joyas; luego, se asomó a la terraza de su palacio y desde allí contempló con satisfacción su ciudad, que se veía más bella que nunca. Entonces se le ocurrió que ese era un buen lugar para que la comida fuera servida, pues desde allí todos los invitados podrían contemplar su reino. El rey de Uxmal ordenó a sus sirvientes que llevaran mesas hasta la terraza y las adornaran con flores y palmas. Mientras tanto, fue a recibir a sus invitados, que usaban sus mejores trajes para la ocasión.\n" +
                    "Los sirvientes tuvieron listas las mesas rápidamente, pues sabían que el rey estaba ansioso por ofrecer la comida a los presentes. Cuando todo quedó acomodado de la manera más bonita, dejaron sola la comida y entraron al palacio para llamar a los invitados.\n" +
                    "Ese fue un gran error, porque no se dieron cuenta de que sobre la terraza del palacio volaban unos zopilotes, o chom, como se les llama en lengua maya. En ese entonces, estos pájaros tenían plumaje de colores y elegantes rizos en la cabeza. Además, eran muy tragones y al ver tanta comida se les antojó. Por eso estuvieron un rato dando vueltas alrededor de la terraza y al ver que la comida se quedó sola, los chom volaron hasta la terraza y en unos minutos se la comieron toda.\n" +
                    "Justo en ese momento, el rey de Uxmal salió a la terraza junto con sus invitados. El monarca se puso pálido al ver a los pájaros saborearse el banquete.\n" +
                    "Enojadísimo, el rey gritó a sus flecheros:\n" +
                    "—¡Maten a esos pájaros de inmediato!\n" +
                    "Al oír las palabras del rey, los chom escaparon a toda prisa; volaron tan alto que ni una sola flecha los alcanzó.\n" +
                    "—¡Esto no se puede quedar así! ?gritó el rey de Uxmal? Los chom deben ser castigados.\n" +
                    "?No se preocupe, majestad; pronto hallaremos la forma de cobrar esta ofensa —contestó muy serio uno de los sacerdotes, mientras recogía algunas plumas de zopilote que habían caído al suelo.\n" +
                    "Los hombres más sabios se encerraron en el templo; luego de discutir un rato, a uno de ellos se le ocurrió cómo castigarlos. Entonces, tomó las plumas de chom y las puso en un bracero para quemarlas; poco a poco, las plumas perdieron su color hasta volverse negras y opacas.\n" +
                    "Después, uno de los sacerdotes las molió hasta convertirlas en un polvo negro muy fino, que echó en una vasija con agua. Pronto, el agua se volvió un caldo negro y espeso. Una vez que estuvo listo, los sacerdotes salieron del templo. Uno de ellos buscó a los sirvientes y les dijo:\n" +
                    "—Lleven comida a la terraza del palacio, la necesitamos para atraer a los zopilotes.\n" +
                    "La orden fue obedecida de inmediato y pronto hubo una mesa llena de platillos y muchos chom que volaban alrededor de ella. Como el día de la fiesta todo les había salido muy bien, no lo pensaron dos veces y bajaron a la terraza para disfrutar de otro banquete.\n" +
                    "Pero no contaban con que esta vez los hombres se escondieron en la terraza; apenas habían puesto las patas sobre la mesa, cuando dos sacerdotes salieron de repente y lanzaron el caldo negro sobre los chom, mientras repetían unas palabras extrañas. Uno de ellos alzó la voz y dijo:\n" +
                    "—No lograrán huir del castigo que merecen por ofender al rey de Uxmal. Robaron la comida de la fiesta de Hunab ku, el Señor que nos da la vida, y por eso jamás probarán de nuevo alimentos tan exquisitos. A partir de hoy estarán condenados a comer basura y animales muertos, sólo de eso se alimentarán.\n" +
                    "Al oír esas palabras y sentir sus plumas mojadas, los chom quisieron escapar volando muy alto, con la esperanza de que el sol les secara las plumas y acabara con la maldición, pero se le acercaron tanto, que sus rayos les quemaron las plumas de la cabeza. Cuando los chom sintieron la cabeza caliente, bajaron de uno en uno a la tierra; pero al verse, su sorpresa fue muy grande. Sus plumas ya no eran de colores, sino negras y resecas, porque así las había vuelto el caldo que les aventaron los sacerdotes. Además, su cabeza quedó pelona. Desde entonces, los chom vuelan lo más alto que pueden, para que los demás no los vean y se burlen al verlos tan cambiados. Sólo bajan cuando tienen hambre, a buscar su alimento entre la basura, tal como dijeron los sacerdotes.", R.drawable.leyenda2));

        listaLeyendas.add(new LeyendasV("La princesa y el Maquech","Esta leyenda relata un juramento de amor entre la princesa Cuzán y su amante Chalpol, un joven con el cabello color rojo.","Cuzán era la hija preferida de Ahnú Dtundtunxcaán, el Gran Señor que se sumerge en el cielo. Era alegre y feliz, y su rostro brillaba como el sol cuando su padre ponía a sus pies lo más bello de sus tesoros de guerra. Cuando Cuzán tuvo edad para el matrimonio, su padre concertó la unión con el hijo del Halach Uinic de la gran ciudad de Nan Chan, el príncipe Ek Chapat, el futuro Señor del Reino. Cuzán aceptó la elección de su padre.\n" +
                    "Un día, al regresar de la guerra, el rey envió los tesoros del botín a Cuzán. Cuando la princesa fue a la sala del Gran Palacio para agradecerle a su padre el rico presente, lo halló acompañado de un hermoso joven llamado Chalpol, Cabeza roja, porque su cabello era de color encendido. Sus almas quedaron atrapadas en un lazo de fuego.\n" +
                    "El corazón desbocado de la princesa sólo hallaba sosiego en el nombre de Chalpol. Juraron no olvidarse nunca y se amaron con locura bajo la ceiba sagrada, donde los dioses escuchan las plegarias de los mortales. Todos en la ciudad sabían que Cuzán estaba prometida al príncipe Ek Chapat de la ciudad de Nan Chan. Por eso cuando el rey supo que Chalpol era el amante de su hija, ordenó que fuera sacrificado. Cuzán le suplicó que le perdonara la vida, pero todo fue en vano.\n" +
                    "El día señalado Chalpol fue pintado de azul para la ceremonia del sacrificio. Hasta el atrio del templo llegaba el aroma del copal que se quemaba para expulsar los espíritus. Con los ojos llenos de lágrimas, Cuzán volvió a pedir a su padre que no lo sacrificara, prometiendo que jamás lo volvería a ver y que aceptaría con obediencia ser la esposa del príncipe de Nan Chan. Después de consultar con los sacerdotes, el Halach Uinic le perdonó la vida, bajo la única condición de que su hija se encerrara en sus habitaciones. Si salía, Chalpol sería sacrificado.\n" +
                    "En la soledad de su alcoba, la princesa entró en la senda del misterio. En el silencio de la noche, fue llamada a presentarse ante el Halach Uinic. Cuando llegó a los patios del templo sus ojos buscaron los de su amado. Tembló al pensar que lo hubieran sacrificado. Le preguntó a su padre, quien sólo sonrió. Un hechicero se le acercó ofreciéndole un escarabajo y le dijo “Cuzán, aquí tienes a tu amado Chalpol. Tu padre le concedió la vida, pero me pidió que lo convirtiera en un insecto por haber tenido la osadía de amarte.\n" +
                    "El mejor joyero del reino lo cubrió de piedras preciosas y le sujetó una de sus patitas con una cadenita de oro. Ella lo prendió a su pecho y le dijo: “Maquech, eres un hombre, escucha el latido de mi corazón, en él vivirás por siempre. He jurado a los dioses no olvidarte nunca”. “Maquech, los dioses no han conocido nunca un amor tan intenso y tan vivo como este que consume mi alma”. La princesa Cuzán y su amado Chalpol, convertido en Maquech, se amaron por encima de las leyes del tiempo, con un amor colmado de eternidad.\n", R.drawable.leyenda3));


        listaLeyendas.add(new LeyendasV("La Flor de Mayo","Esta leyenda narra la historia de una niña, hija de un devoto que no podía tener hijos y como le pide a los dioses que le den la oportunidad de ser padre.","Este hombre se pasaba todas las noches contemplando el cielo nocturno, sobre todo en el mes de mayo. Y has de saber que aunque estaba casado con muchacha guapa, la naturaleza le había negado descendencia y eso lo entristecía profundamente. Por esa razón, todos los días suplicaba a los dioses que le concedieran la dicha de tener una hija tan bella como las estrellas que tanto admiraba.\n" +
                    "Y los dioses escucharon sus ruegos. Su esposa al fin quedó en cinta y en el mes de mayo dio a luz a una niña primorosa, la cual causó gran asombro porque no tenía la piel morena como la de sus padres, sino más bien blanca, pero pálida. El padre pensó cómo pudo haber pasado aquello, y entonces comprendió que los dioses le concedieron el deseo de tener una hija tan blanca y bella como las estrellas de la Cruz del Sur. Le contó este secreto a su mujer, y ambos quedaron convencidos de que se trataba de un milagro.\n" +
                    "Le pusieron el nombre de Sac-Nicté (flor blanca) a la niña, que fue creciendo cada día más hermosa, pero también más pálida y enfermiza. Su tez parecía de cera, y todas las noches miraba con nostalgia a los cielos, como si las estrellas algo le dijeran.\n" +
                    "Cuando llegó a la pubertad, se le veía más triste y débil, y su salud empeoró ocasionando la alarma de sus padres. Vinieron en su auxilio los mejores curanderos de la región y todos coincidieron en manifestar su ignorancia respecto a la enfermedad de la pequeña. Comentaban que sus pócimas y conjuros nada podían hacer frente a aquel mal desconocido, por lo que concluyeron que los dioses habían decidido llevarse a la enfermita.\n" +
                    "Fue así que en el mes de mayo, cuando la Cruz del Sur brilla en su máximo esplendor y la primavera engalana los campos, murió la pequeña Sac-Nicté. Sus padres estaban sumamente desconsolados, pero el hombre soñó que una voz misteriosa le dijo que dejara de llorar porque su hija ya no sufría; que había sido voluntad de los dioses que regresara al cielo, a donde pertenecía, ya que ella era una estrella de la Cruz del Sur que tomó forma humana para cumplir el ferviente deseo del padre. Y ahora ella refulgía de nuevo en el firmamento, al lado de sus hermanas estrellas.\n" +
                    "Todo el pueblo y sus padres lamentaron la muerte de la niña, y le hicieron un pomposo entierro en el humilde cementerio del lugar. Y se sabe que en el mes de mayo del año siguiente, sobre la tumba de la niña nació un árbol que da bellas flores luminosas como las estrellas de la Cruz del Sur.\n" +
                    "De esta manera se conoció por primera vez el aroma dulce y misterioso de una flor que en mayo nació en el Mayab. Todos los años florece en el mes de mayo, cuando resplandece en el cielo la Cruz del Sur. Por eso se llama Flor de Mayo el árbol y su flor.\n", R.drawable.leyenda4));


        listaLeyendas.add(new LeyendasV("Uay Chivo","La leyenda Uay Chivo refiere a un hechicero o brujo representado como un ente de color negro, de ojos brillantes y grandes cuernos. Su misión es asustar a quienes aparecen en su camino por las noches.","En los poblados del interior del estado es común escuchar diversas anécdotas sobre encuentros con esta entidad, se dice que si una persona se cruza en el mismo camino que él, debe desviar la mirada, de esta forma sentirá solamente un frío intenso y un mal olor, pero si lo mira, a las pocas horas presentará fiebres y malestares producto de “un mal aire”.\n" +
                    "Se dice que el Huay Chivo se alimenta de las gallinas y el ganado de los pobladores y que habita en los más recónditos y oscuros lugares, como en los bosques y montes. Existe una muy conocida frase que advierte a todo caminante nocturno cuidarse de este ser amante de la oscuridad, pues de tener contacto con él su maldad se dejará caer.\n" +
                    "Para que un brujo pueda obtener la habilidad de transformarse es necesario que realice un rito oscuro, en el que ofrezca precisamente un chivo, después de una serie de procedimientos, el brujo se convierte en mitad hombre, mitad animal, con esta forma sale a asustar y matar animales.\n" +
                    "Hay quienes narran haberlo visto y haber sido afectados por él, sus experiencias son aterradoras, para buena suerte no son muchos quienes han logrado verlo, pero en lo que se comprueba o rechaza su existencia es mejor andar prevenido.\n" +
                    " \n" +
                    "“Caminante, cuídate al andar después de la media noche por los lugares donde el Huay Chivo ronda, pues este ser de oscuridad puede dejar caer en ti toda su maldad”.\n"
                , R.drawable.leyenda5));


        listaLeyendas.add(new LeyendasV("Uay","La leyenda cuenta que el Uay es un mago o hechicero que realiza fenómenos de encantamiento inherentes a la magia negra. ","Los Huay Brujos son seres humanos como nosotros solo que ellos, tienen podrido el corazón, practican la magia negra de la maldad, le venden su alma al Kisín (Diablo) a cambio de favores malignos. Es por eso que tienen la facilidad de transformarse en mitad humano y mitad animal adoptando la forma del huay perro, huay chivo, huay gato, huay keken (Cochino), etc. También hay brujas de magia negra que adoptan la forma animal. Huay quiere decir espanto de la media noche.\n" +
                    "Estos mentados brujos adoptan cualquier forma animal para espantar a la gente o para hacer sus fechorías. Tiran las albarradas de las casas, matan animales. Después de hacerlo, le comen los sesos. Los brujos de magia negra son muy tramposos. A veces le dan brebajes a las mujeres para adormecerlas y así poder abusar de ellas. Para poderse transformar en Huay chivo, hacen un círculo con velas negras. Le arrancan el corazón a una cabra para luego beberse la sangre.\n" +
                    "Hacen la ofrenda a su amo del mal, rezan el padre nuestro nueve veces al derecho y al revés. Como quien dice de principio a fin y de final al inicio. Luego dan nueve volantines al derecho y al revés. Al último volantín se transforman en espanto, para luego salir a recorrer las calles de los pueblos. Extraños y inexplicables casos se pueden escuchar en la actualidad, acerca de estos míticos brujos mayas.", R.drawable.leyenda6));


        listaLeyendas.add(new LeyendasV("El enano de Uxmal","La leyenda cuenta la historia de una señora anciana que trabajaba en el oráculo del pueblo y que no podía tener hijos.","Durante el imperio de Uxmal, se dice vivió en la ciudad de Kabah una mujer hechicera de edad avanzada quien cuidaba celosamente un huevo que había encontrado de manera misteriosa, a diario se sentaba junto a él a tomar el sol hasta que un día del huevo brotó un niño, la mujer resignada por su edad a no tener hijos cuido al niño como suyo, el tiempo pasaba pero el niño se mantenía del mismo tamaño, la mujer notó que comenzaba a salirle barba la voz le engrosaba, así descubrió que se trataba de un enano.\n" +
                    "Un día el enano guiado por su curiosidad y el descuido de la anciana se decidió averiguar qué era lo que la mujer cuidaba de manera excesiva frente a un caldero, al acercarse descubrió un Tunkul (instrumento hecho con un palo hueco y que genera un sonido muy fuerte) fue tan alto el alcance del tono emitido que se escuchó resonar en la ciudad de Uxmal. Ya estaba vaticinado que al oírse el cantar del Tunkul el reinado del actual mandatario llegaría a su fin, de inmediato el rey mandó encontrar al culpable de tal anuncio, al llegar frente a él, preguntó al enano si había algún modo de evitar que eso ocurriera, el enano pidió al rey que primeramente mandara labrar un camino que vaya desde Kabah hasta Uxmal, terminado el camino él regresaría a decirle la respuesta.\n" +
                    "Ya listo el camino la bruja acompañada de su protegido se dirigieron a la ciudad que ya les esperaba ansiosos por conocer la respuesta. Al llegar mencionó el enano que daría la solución solamente si el Rey superaba una prueba que consistía en romper con la cabeza el fruto más duro que se conoce en la zona yucateca, conocido como Cocoyol, el mandatario aceptó con la condición de que fuera primeramente el retador quien la realizara, el Enano accedió habiendo colocado de antemano por parte de la anciana una capa dura de metal bajo su cabeza, como era de esperarse éste resistió al golpe; al llegar el turno del Rey se colocó en el lugar que se le indicó y al primer golpe cayó en muerte.\n" +
                    "Posterior a tal suceso el Enano fue coronado Rey de Uxmal, la anciana le dirigió sabias palabras en las que le indicaba que ahora ella podía morir tranquila pues sabía que el lugar quedaba en buenas manos, de igual forma le indicó ser justo y actuar de manera correcta sin dejarse cegar por el poder, así trabajó el nuevo jefe durante un tiempo, al paso de los años fue olvidando aquella conversación y se fue dejando envolver por la malicia, al grado de un día anunciar la creación de un nuevo dios que sería superior a los ya existentes, así mandó labrar en barro una escultura, ésta fue puesta en la lumbre para endurecerla y así asegurar su resistencia, pero al ser retirado del calor la imagen vibró de tal manera que los habitantes creyeron que la estatua hablaba venerándolo y adorándolo más que a los dioses.\n" +
                    "Ese acto de fanatismo creo un gran disgusto en los verdaderos seres supremos por lo cual en castigo a semejante falta la Ciudad de Uxmal fue destruida acabando así con el gran poderío que hubo logrado a lo largo de tanto tiempo, hundiendo también el dominio del Enano que por soberbia llevó a su pueblo a la peor de las catástrofes.", R.drawable.leyenda7));


        listaLeyendas.add(new LeyendasV("La creación de la Tierra","Según la leyenda maya sobre la creación de la tierra, antes de la existencia de la misma existían sólo dos dioses: Tepeu y Gucumatz. Ellos fueron quienes se unieron para crear el mundo.","Un buen día, las aves de la tierra del Mayab prepararon un suntuoso banquete en honor de su rey, el pavo real. Todos los pájaros fueron invitados a la fiesta, y se nombró una comisión especial para escoltar a Tunkuluchú, el búho.\n" +
                    "El búho detestaba esos convites; sin embargo, los miembros de la comisión, temiendo la cólera del rey, lo convencieron de que, como gran consejero de la corte, estaba obligado a presidir el banquete.\n" +
                    "El rey había reservado un lugar a su lado para el gran consejero, y tan pronto éste llegó, comenzó la alegre velada: los meseros pasaban las viandas en frescas y verdes hojas, y ante cada uno de los sedientos comensales, colocaban pétalos de flores, simulando pequeñas ánforas repletas de rocío. Poco tiempo después, todos los asistentes, con la excepción del búho, se divertían a sus anchas\n" +
                    "El búho, no pudiendo soportar la gritería y el comportamiento de los demás, trató de escabullirse, y fue visto por el rey, quien lo hizo retornar. Éste obedeció la orden real, pero posándose en una elevada rama le volvió la espalda a los escandalosos y alegres convidados.\n" +
                    "El pavo real, creyendo que el desaire iba dirigido a él, resolvió hacer uso de su autoridad para obligar al búho a tomar parte activa en la festividad e, inmediatamente, le ordenó que bailara con los otros y uniera su voz al discordante coro de los allí reunidos.\n" +
                    "El búho se sintió humillado con las crueles burlas que le hicieron las otras aves después de la celebración. Y ni la necesidad natural de alimentarse ni las súplicas de sus amigos, le hicieron salir de su guarida.\n" +
                    "Movido por el deseo de exponer a su rey al ridículo, tal y como éste había hecho con él, el sabio consejero consultó el libro sagrado de los Mayas, donde encontró la manera en que el pavo real había engañado al candoroso Puhuy.\n" +
                    "Fue así que el búho invitó a los pájaros de la floresta del Mayab para una gran asamblea y, al dirigirse a los presentes, se percató que no podía leer una sola palabra. Entonces, lanzando un grito de desesperación, dejó caer el pergamino al suelo.\n" +
                    "Los días permanecidos en el interior de su morada, hicieron que sus ojos se acostumbraran a la oscuridad. Ahora la luz brillante de la mañana lo cegaba. Desde esa ocasión, pocas veces se le ve durante el día. Su anhelo de venganza contra el rey fue castigado por los dioses.\n"
                , R.drawable.leyenda8));


        listaLeyendas.add(new LeyendasV("Cuando el Tunkuluchú canta…","La leyenda narra la historia de un ave misteriosa y solitaria que sobrevuela las ruinas de Mayab, a la que llaman Tukulunchú. Con su canto anuncia la muerte, por lo que todos le temen.","n El Mayab vive un ave misteriosa, que siempre anda sola y vive entre las ruinas. Es el tecolote o tunkuluchú, quien hace temblar al maya con su canto, pues todos saben que anuncia la muerte.\n" +
                    "Algunos dicen que lo hace por maldad, otros, porque el tunkuluchú disfruta al pasearse por los cementerios en las noches oscuras, de ahí su gusto por la muerte, y no falta quien piense que hace muchos años, una bruja maya, al morir, se convirtió en el tecolote.\n" +
                    "También existe una leyenda, que habla de una época lejana, cuando el tunkuluchú era considerado el más sabio del reino de las aves. Por eso, los pájaros iban a buscarlo si necesitaban un consejo y todos admiraban su conducta seria y prudente.\n" +
                    "Un día, el tunkuluchú recibió una carta, en la que se le invitaba a una fiesta que se llevaría a cabo en el palacio del reino de las aves. Aunque a él no le gustaban los festejos, en esta ocasión decidió asistir, pues no podía rechazar una invitación real. Así, llegó a la fiesta vestido con su mejor traje; los invitados se asombraron mucho al verlo, pues era la primera vez que el tunkuluchú iba a una reunión como aquella.\n" +
                    "De inmediato, se le dio el lugar más importante de la mesa y le ofrecieron los platillos más deliciosos, acompañados por balché, el licor maya. Pero el tunkuluchú no estaba acostumbrado al balché y apenas bebió unas copas, se emborrachó. Lo mismo le ocurrió a los demás invitados, que convirtieron la fiesta en puros chiflidos y risas escandalosas. \n" +
                    "Entre los más chistosos estaba el chom, quien adornó su cabeza pelona con flores y se reía cada vez que tropezaba con alguien. En cambio, la chachalaca, que siempre era muy ruidosa, se quedó callada. Cada ave quería ser la de mayor gracia, y sin querer, el tunkuluchú le ganó a las demás. Estaba tan borracho, que le dio por decir chistes mientras danzaba y daba vueltas en una de sus patas, sin importarle caerse a cada rato.\n" +
                    "En eso estaban, cuando pasó por ahí un maya conocido por ser de veras latoso. Al oír el alboroto que hacían los pájaros, se metió a la fiesta dispuesto a molestar a los presentes. Y claro que tuvo oportunidad de hacerlo, sobre todo después de que él también se emborrachó con el balché.\n" +
                    "El maya comenzó a reírse de cada ave, pero pronto llamó su atención el tunkuluchú. Sin pensarlo mucho, corrió tras él para jalar sus plumas, mientras el mareado pájaro corría y se resbalaba a cada momento. Después, el hombre arrancó una espina de una rama y buscó al tunkuluchú; cuando lo encontró, le picó las patas. Aunque el pájaro las levantaba una y otra vez, lo único que logró fue que las aves creyeran que le había dado por bailar y se rieran de él a más no poder. \n" +
                    " \n" +
                    "\n" +
                    "Fue hasta que el maya se durmió por la borrachera que dejó de molestarlo. La fiesta había terminado y las aves regresaron a sus nidos todavía mareadas; algunas se carcajeaban al recordar el tremendo ridículo que hizo el tunkuluchú. El pobre pájaro sentía coraje y vergüenza al mismo tiempo, pues ya nadie lo respetaría luego de ese día.\n" +
                    "Entonces, decidió vengarse de la crueldad del maya. Estuvo días enteros en la búsqueda del peor castigo; era tanto su rencor, que pensó que todos los hombres debían pagar por la ofensa que él había sufrido. Así, buscó en sí mismo alguna cualidad que le permitiera desquitarse y optó por usar su olfato. Luego, fue todas las noches al cementerio, hasta que aprendió a reconocer el olor de la muerte; eso era lo que necesitaba para su venganza.\n" +
                    "Desde ese momento, el tunkuluchú se propuso anunciarle al maya cuando se acerca su hora final. Así, se para cerca de los lugares donde huele que pronto morirá alguien y canta muchas veces. Por eso dicen que cuando el tunkuluchú canta, el hombre muere. Y no pudo escoger mejor desquite, pues su canto hace temblar de miedo a quien lo escucha.\n" , R.drawable.leyenda9));
}




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
