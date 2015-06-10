package info.goodline.starsandplanets.data;

import android.content.res.Resources;

import java.util.ArrayList;

import info.goodline.starsandplanets.R;

/**
 * Created by sergeyb on 10.06.15.
 */
public class SpaceBody {
    public static final int FLAG_GET_GALAXIES=0;
    public static final int FLAG_GET_STARS=1;
    public static final int FLAG_GET_PLANETS=2;


    private String mName;
    private String mLink;

    public SpaceBody() {
    }

    public SpaceBody(String name, String link) {
        mName = name;
        mLink = link;
    }

    public static String[] getSpaceBodyGroup( Resources resources) {
        String[] groupNames = resources.getStringArray(R.array.space_body_group_name);
        return groupNames;
    }


        public static ArrayList<SpaceBody> getSpaceBodyFromResource(int spaceBodyFlag, Resources resources){
        String[] spaceBodies = new String[0];
        String[] spaceBodiesLinks  = new String[0];
        ArrayList<SpaceBody> spaceBodyArrayList;

            switch (spaceBodyFlag){
            case FLAG_GET_GALAXIES:
                spaceBodies = resources.getStringArray(R.array.galaxy_name);
                spaceBodiesLinks = resources.getStringArray(R.array.galaxy_link);
                spaceBodyArrayList = new ArrayList<>(spaceBodies.length);
                for (int i = 0; i < spaceBodies.length; i++) {
                    SpaceBody spaceBody=new SpaceBody(spaceBodies[i],spaceBodiesLinks[i]);
                    spaceBodyArrayList.add(spaceBody);
                }

                return spaceBodyArrayList;

            case FLAG_GET_STARS:
                spaceBodies = resources.getStringArray(R.array.star_name);
                spaceBodiesLinks = resources.getStringArray(R.array.star_link);
                spaceBodyArrayList = new ArrayList<>(spaceBodies.length);
                for (int i = 0; i < spaceBodies.length; i++) {
                    SpaceBody spaceBody=new SpaceBody(spaceBodies[i],spaceBodiesLinks[i]);
                    spaceBodyArrayList.add(spaceBody);
                }

                return spaceBodyArrayList;

            case FLAG_GET_PLANETS:
                throw new IllegalArgumentException("Not implimented yet.");
            default:
                return new ArrayList<>();
        }
    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }
}