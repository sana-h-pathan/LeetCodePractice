class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> logList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for(String log: logs){
            String[] splitLogs = log.split(" ");
            if(Character.isDigit(splitLogs[1].charAt(0))){
                digitList.add(log);
            } else {
                logList.add(log);
            }
        }
        Collections.sort(logList, (String a,String b)->{
            String[] log1 = a.split(" ", 2);
            String[] log2 = b.split(" ", 2);
            int comp = log1[1].compareTo(log2[1]);
            if(comp==0){
                return log1[0].compareTo(log2[0]);
            }
            return comp;
        });
        int i=0;
        for(String log: logList){
            logs[i]=log;
            i++;
        }
        for(String log: digitList){
            logs[i]=log;
            i++;
        }
        return logs;
    }
}