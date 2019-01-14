package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int courseNumber = bundle.getInt("CourseNr")+1;
            switch (courseNumber){
                case 1 :{
                    TextView content = (TextView) findViewById(R.id.courseContent);
                    content.setText("Donec imperdiet consequat massa eu consequat. Praesent nec vestibulum eros. Donec sed libero iaculis, vulputate tellus nec, porttitor odio. Etiam lobortis urna sapien, eget facilisis erat faucibus et. Mauris vel tincidunt neque, sit amet maximus ex. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor felis velit, at tempor magna dictum ut. Proin id pretium odio. Vivamus vel diam eu ex efficitur laoreet non at ante. Integer nec tortor eu mi tincidunt convallis eu at sem. Quisque felis orci, tempor sit amet dolor et, laoreet luctus augue. Quisque nisi justo, lobortis facilisis interdum vitae, tempor et magna.\n" +
                            "\n" +
                            "Nulla facilisi. Duis vitae molestie lectus. Vestibulum egestas, nibh quis iaculis tincidunt, lorem tellus aliquet turpis, at sollicitudin enim lectus id metus. Donec ultricies nec libero vitae aliquet. Donec congue nisl sed ipsum sodales, id ultrices urna luctus. Morbi velit est, rhoncus eu erat a, mattis commodo ante. Suspendisse potenti. Aliquam dictum augue nunc, id placerat justo laoreet nec. Pellentesque elementum arcu id felis sollicitudin, ut commodo metus aliquam. Maecenas congue pellentesque justo, ac ultrices lacus. Morbi ultricies vulputate nulla, nec consequat urna interdum id.\n" +
                            "\n" +
                            "Ut congue, tellus sed molestie ultrices, neque dui mollis diam, eget porttitor leo ipsum eget metus. Nunc eget sodales enim, a placerat nisi. Suspendisse potenti. Nunc id quam mauris. Sed quis iaculis diam. Praesent sagittis justo sollicitudin, sagittis nisl nec, ullamcorper nisl. Cras sodales ipsum id aliquet finibus. Duis augue urna, suscipit sit amet ultricies quis, condimentum a mauris. Sed gravida sollicitudin nibh vitae efficitur. Morbi fringilla ipsum neque, eu fermentum mauris luctus eget. Nunc quis lacus justo. Donec ac laoreet ipsum. Etiam pulvinar nibh vitae felis semper maximus. Cras quis lorem ex. Nullam id massa ut urna efficitur vulputate et a sapien.\n" +
                            "\n" +
                            "Duis feugiat lacinia elit, quis lobortis quam bibendum nec. Cras ante ex, tincidunt a posuere vitae, elementum eu libero. Etiam eu ultrices lorem. Proin consequat vehicula dui, vitae facilisis nisl blandit sed. In rhoncus ex velit, nec mollis ipsum dapibus ac. Nullam suscipit est et nisi commodo, eu dignissim ante luctus. Curabitur elementum dapibus ex, vitae iaculis ipsum rutrum id. Suspendisse eu nunc enim. Curabitur eget porttitor tortor. Duis pellentesque rutrum nisl ac finibus. Praesent ut diam in arcu fringilla rhoncus. Ut vitae sodales nisi. Sed sed ex quis felis tincidunt mollis eu vitae quam. Cras vestibulum elementum rutrum. Curabitur vitae varius ex. Phasellus facilisis nisl aliquet neque pharetra, non imperdiet elit posuere.\n" +
                            "\n" +
                            "Morbi vulputate mattis nisi non accumsan. Mauris ultricies finibus eros commodo ullamcorper. Vivamus interdum neque sed lorem mollis, eu lobortis metus dapibus. Integer tincidunt sagittis tortor sed ornare. Maecenas finibus nibh quis nulla imperdiet, quis sollicitudin nibh viverra. Proin et risus sit amet sem suscipit imperdiet quis sed tellus. Quisque dignissim magna vel nunc maximus ullamcorper. In consectetur magna sed augue placerat, sed faucibus ligula semper. Pellentesque aliquam neque vel ex faucibus, ac scelerisque dolor condimentum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque auctor sodales erat, nec eleifend nulla tincidunt eget. Aenean in hendrerit mauris, at semper odio. Curabitur condimentum diam in augue vulputate rhoncus.\n" +
                            "\n" +
                            "Cras commodo, eros quis rutrum rhoncus, sapien mauris egestas nisi, sed suscipit justo tellus vitae metus. Phasellus aliquet imperdiet dolor, at sodales odio tincidunt vel. Donec posuere consectetur dui porta maximus. Mauris rutrum augue a sem gravida, non vehicula lorem aliquet. Fusce sollicitudin est iaculis sem ultricies, sed aliquam dui varius. Proin ac semper felis. Sed eros nunc, ullamcorper et convallis et, scelerisque ac magna. Sed nec sagittis massa.\n" +
                            "\n" +
                            "Curabitur pretium finibus turpis, feugiat accumsan purus finibus eget. Fusce efficitur, tortor non condimentum imperdiet, sapien nibh pellentesque eros, a efficitur nunc nisl at turpis. In hac habitasse platea dictumst. Morbi at mauris et dolor aliquet ultrices. In elementum ac libero sit amet convallis. Sed egestas viverra est. Curabitur eget ligula ut leo lacinia auctor. Suspendisse mattis dolor vitae elit porta, eget lacinia ex tincidunt. Fusce ac lacus id libero posuere accumsan in et metus. Ut scelerisque pulvinar massa luctus bibendum. In eget fermentum lacus, eget congue ligula. In in venenatis nunc. Fusce dignissim, ipsum nec auctor blandit, mauris risus porttitor turpis, id mollis est urna mollis quam. Suspendisse sit amet lacus tempus, mattis mauris eget, semper massa. Etiam placerat nunc non dui consectetur commodo.\n" +
                            "\n" +
                            "Donec commodo pharetra nunc eu rhoncus. Aliquam purus augue, porttitor vel pretium vitae, dignissim et augue. Donec risus elit, malesuada accumsan dui ut, cursus bibendum orci. Etiam bibendum diam quis eros volutpat pellentesque. Aliquam sed lectus scelerisque, porta ex vel, volutpat tellus. Mauris dictum sapien id velit lacinia lobortis. Donec enim velit, tincidunt ut tempus vel, lobortis quis orci. Donec id ligula volutpat, efficitur quam vitae, eleifend odio. Praesent quis purus ut tellus tincidunt interdum. Vestibulum aliquet ornare rhoncus. Morbi facilisis risus ac velit semper, ac pulvinar neque mattis.\n" +
                            "\n" +
                            "Ut fringilla nulla ex. Integer eu ligula efficitur, tincidunt ipsum placerat, convallis odio. Proin ac odio vitae mauris facilisis aliquet. Donec eget orci nulla. Curabitur consectetur cursus lorem, a aliquet eros tincidunt a. Fusce accumsan, neque at mattis luctus, massa diam volutpat ex, a euismod lorem tortor nec metus. Aenean luctus augue ut vestibulum commodo. Proin tempor arcu a nulla viverra facilisis. Quisque ac sodales est. Vivamus fringilla dui ipsum, quis posuere erat pharetra ut. Donec euismod vitae massa non mattis. Maecenas a lorem enim.\n" +
                            "\n" +
                            "Nunc at nisl venenatis, varius nibh id, varius magna. Vestibulum faucibus vitae orci non feugiat. Sed hendrerit lorem ut diam consequat, at rhoncus lectus gravida. Aenean id auctor leo. Nulla a consequat leo. Suspendisse placerat hendrerit urna, quis tristique metus luctus eu. Donec eu justo eu lacus rutrum imperdiet nec vel erat. Nam lobortis sapien eget lacus gravida, quis auctor leo mattis. Nunc scelerisque turpis sit amet dolor euismod, nec cursus leo ullamcorper. Donec fermentum eget dui et commodo. Vivamus quis dictum purus. Morbi ut ullamcorper ex. Aliquam efficitur fermentum erat, vel aliquet ante pharetra sed. Praesent et faucibus ante. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
                    content.setMovementMethod(new ScrollingMovementMethod());
                    break;
                }

                case 2 :{
                    TextView content = (TextView) findViewById(R.id.courseContent);
                    content.setText("In pulvinar mi in nisl condimentum malesuada. In condimentum augue vitae iaculis malesuada. Etiam sollicitudin ante diam, ac sodales lorem pulvinar ullamcorper. Praesent aliquam aliquam gravida. Donec aliquam commodo turpis pulvinar scelerisque. Praesent accumsan eget nisl tincidunt ultrices. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Phasellus sed finibus orci, sed dapibus lorem. Etiam turpis sem, pulvinar ac leo sed, vehicula commodo purus. Ut bibendum sapien est, nec lacinia est feugiat quis. Maecenas faucibus ipsum commodo augue vestibulum lobortis. Suspendisse et imperdiet est. Nullam ullamcorper fermentum turpis vitae pellentesque. Vivamus nibh ligula, dapibus efficitur convallis sit amet, laoreet eu velit. Duis interdum, justo sed porttitor feugiat, purus justo cursus lectus, eget commodo tortor justo quis orci. Suspendisse id lacus eu metus ultrices rutrum ut et lorem.\n" +
                            "\n" +
                            "Nam nunc nisl, mollis facilisis odio non, laoreet volutpat turpis. In condimentum lobortis odio, in convallis justo porttitor non. Nulla fringilla feugiat sem at pharetra. Etiam urna dolor, maximus eu pharetra vitae, vehicula id urna. Nam nibh urna, mattis eget aliquam blandit, mollis a tellus. Vestibulum dignissim mollis ante et tempus. Vestibulum feugiat urna vitae lacus elementum bibendum. Suspendisse vitae eleifend risus. Donec eget velit non libero pulvinar molestie. Nulla efficitur, arcu ac sollicitudin faucibus, sapien elit viverra elit, ut scelerisque leo nunc a ipsum.\n" +
                            "\n" +
                            "Integer id convallis felis. In eget pretium magna. Fusce in sem et mauris iaculis elementum. Sed nec massa id lectus eleifend sollicitudin. Morbi placerat lacus at odio finibus, feugiat finibus dui luctus. Maecenas vehicula ex ac neque suscipit lobortis. Integer pretium dui nec risus fermentum consequat.\n" +
                            "\n" +
                            "Mauris vitae orci maximus, porta metus nec, semper neque. Ut malesuada libero in commodo pellentesque. In hac habitasse platea dictumst. Fusce dignissim fermentum metus, quis sagittis nulla. Praesent sed metus id erat dictum aliquam vel porttitor elit. Pellentesque a tincidunt nibh. Morbi euismod mauris purus, vitae blandit ligula fermentum vitae. Sed ac lacinia nisl, eu varius lorem. Ut laoreet sed eros eget rhoncus.\n" +
                            "\n" +
                            "Vestibulum in nunc id purus feugiat consectetur. Suspendisse volutpat nulla justo, id rhoncus dui gravida et. Proin arcu nisi, pharetra quis condimentum eu, faucibus sed augue. Vivamus felis neque, fermentum a ultricies imperdiet, aliquet eu diam. Nulla ut placerat nibh, eget pharetra arcu. Vestibulum fermentum ex id nibh aliquet venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam blandit varius nisl, et condimentum nibh scelerisque et.\n" +
                            "\n" +
                            "Integer luctus mi in nulla iaculis, sed porta enim ultrices. Maecenas sapien lectus, vestibulum eget purus vel, vulputate cursus lorem. Suspendisse potenti. Vestibulum ultricies nisl suscipit tellus maximus porta. Nulla sit amet mattis nunc. Nam molestie nibh et dictum hendrerit. Aenean blandit nec felis imperdiet feugiat. Sed purus urna, condimentum rutrum venenatis eu, tempus sed turpis. Donec non arcu efficitur, sagittis neque ac, ullamcorper lorem. Nullam at mi eu tellus accumsan lobortis ut at ex. Curabitur pharetra elit urna, nec vestibulum ipsum venenatis a. Ut nec massa pharetra, sollicitudin risus ac, blandit risus. Sed venenatis nec arcu a pellentesque. Quisque ultrices vestibulum mi a sollicitudin.\n" +
                            "\n" +
                            "Ut at neque ac ex auctor elementum. Fusce aliquam et magna ultrices aliquam. Praesent sollicitudin luctus mi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas ultricies iaculis dui ut auctor. Donec vel nisi quis leo fermentum commodo nec non arcu. Curabitur sed scelerisque purus. Donec vitae turpis sit amet risus ultricies gravida. Nulla luctus ut nisl quis luctus. Suspendisse lacus massa, fermentum ut elementum et, convallis non nunc. Vestibulum sodales purus erat, vitae tempor massa ornare sit amet. Donec leo mauris, varius eget augue eu, aliquet congue ante. Vivamus mattis pretium lectus. Donec semper enim et aliquet tincidunt. Duis tristique libero eu arcu porttitor pharetra. Quisque lacinia metus a nulla lobortis venenatis.\n" +
                            "\n" +
                            "Nulla eget imperdiet lectus. Maecenas blandit, sem sed ullamcorper aliquet, sem leo lobortis lacus, id cursus arcu ante sed nulla. Cras faucibus nisl ac dui molestie, ut dictum elit dignissim. Cras tellus purus, rhoncus eu facilisis nec, porta et lacus. Nullam congue, lacus rhoncus tristique pulvinar, erat purus ultrices lorem, et condimentum nisi purus et dolor. Etiam congue est vel pretium hendrerit. Mauris congue efficitur ligula, eu dapibus mauris sollicitudin et. Morbi sed tincidunt mauris, id tincidunt elit. Mauris convallis metus velit, sed ornare odio sollicitudin id. Nam posuere egestas viverra. Fusce porta purus quis erat venenatis ullamcorper. Pellentesque dictum, nibh in aliquam vestibulum, arcu tellus consectetur tortor, vitae ultrices ex odio eu eros. Cras feugiat nibh mauris, ut feugiat tortor eleifend vitae. Nunc gravida diam risus, vel efficitur nulla eleifend eget. Quisque vel nulla varius, vehicula lectus feugiat, bibendum risus. Integer eu nibh nunc.");
                    content.setMovementMethod(new ScrollingMovementMethod());
                    break;
                }
                default:{
                    Toast.makeText(this, "Cursul nu este disponibil !", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    public void backClick(View view) {
        Intent I=new Intent(CourseActivity.this, CoursesActivity.class);
        startActivity(I);
    }
}
