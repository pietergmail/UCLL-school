package src.domain.db;

import dom;

import java.util.ArrayList;

public class MemberDB{
    private ArrayList<Member> Members = new ArrayList<Member>();

    public void voegtoe(Member member){
        Members.add(member);
    }

    public void verwijder(String voornaam){
        Members.remove(new Member(voornaam));
    }

    public MemberDB(){
        this.voegtoe(new Member("Pieter", "Herremans", "Sparrendreef 19", "Herremanspieter@gmail.com", "2000-08-07"));
    }

    public ArrayList<Member> getAll(){
        return Members;
    }

    public Member Oldest(){
        Member oldest = Members.get(0);
        for(int i = 1; i<Members.size(); i++){
           if (Members.get(i).age() > oldest.age()){
               oldest = Members.get(i);
           }
        }
        return oldest;
    }
}
