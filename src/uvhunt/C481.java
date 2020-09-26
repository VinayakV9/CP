package uvhunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public  class C481<T> {
    private static final List<List<Integer>> memorization = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String s;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while( (s = br.readLine())!= null && !s.isEmpty()){
            arrayList.add(Integer.parseInt(s));
            memorization.add(null);
        }

        List<Integer> increasingSubsequence = Collections.emptyList();
        Integer lastItemSelected = Integer.MIN_VALUE;
        for(int index = arrayList.size()-1; index >=0; index--) {
            increasingSubsequence = findIncreasingSubsequence(arrayList, index, lastItemSelected);
        }
        String result = increasingSubsequence
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        System.out.println(increasingSubsequence.size());
        System.out.println("-");
        System.out.println(result);
    }

    private static List<Integer> findIncreasingSubsequence(List<Integer> list, int index, Integer lastItemSelected) {
        if( index >= list.size()){
            return Collections.emptyList();
        }

        if( list.get(index).compareTo(lastItemSelected) > 0 ){
            List<Integer> result = memorization.get(index);
            if( result != null){
                return result;
            }

            List<Integer> subResultInclusive = new ArrayList<>();
            subResultInclusive.add(list.get(index));
            subResultInclusive.addAll(findIncreasingSubsequence(list, index + 1, list.get(index)));
            List<Integer> subResultExclusive = findIncreasingSubsequence(list, index + 1, lastItemSelected);

            result = (subResultExclusive.size() >= subResultInclusive.size())?
                    subResultExclusive:subResultInclusive;

            //memorize the result
            memorization.add(index, result);

            return result;
        } else {
            return findIncreasingSubsequence(list, index + 1, lastItemSelected);
        }

    }
}
