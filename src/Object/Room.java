//
package Object;

public class Room {
    private int id;
    private int domId;
    private String roomNumber;
    private int numberStudent;
    private int freeSlot;
    private int electricityNumberLastSemester;
    private int electricityNumberThisSemester;
    private int waterNumberLastSemester;
    private int waterNumberThisSemester;
    private boolean paystatus;
    private int status;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDomId() {
        return domId;
    }

    public void setDomId(int domId) {
        this.domId = domId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }

    public int getFreeSlot() {
        return freeSlot;
    }

    public void setFreeSlot(int freeSlot) {
        this.freeSlot = freeSlot;
    }   

    public int getElectricityNumberLastSemester() {
        return electricityNumberLastSemester;
    }

    public void setElectricityNumberLastSemester(int electricityNumberLastSemester) {
        this.electricityNumberLastSemester = electricityNumberLastSemester;
    }

    public int getElectricityNumberThisSemester() {
        return electricityNumberThisSemester;
    }

    public void setElectricityNumberThisSemester(int electricityNumberThisSemester) {
        this.electricityNumberThisSemester = electricityNumberThisSemester;
    }

    public int getWaterNumberLastSemester() {
        return waterNumberLastSemester;
    }

    public void setWaterNumberLastSemester(int waterNumberLastSemester) {
        this.waterNumberLastSemester = waterNumberLastSemester;
    }

    public int getWaterNumberThisSemester() {
        return waterNumberThisSemester;
    }

    public void setWaterNumberThisSemester(int waterNumberThisSemester) {
        this.waterNumberThisSemester = waterNumberThisSemester;
    }

    public boolean isPaystatus() {
        return paystatus;
    }

    public void setPaystatus(boolean paystatus) {
        this.paystatus = paystatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", domId=" + domId + ", roomNumber=" + roomNumber + 
                ", numberStudent=" + numberStudent + ", freeSlot=" + freeSlot + 
                ", electricityNumberLastSemester=" + electricityNumberLastSemester + 
                ", electricityNumberThisSemester=" + electricityNumberThisSemester + 
                ", waterNumberLastSemester=" + waterNumberLastSemester + 
                ", waterNumberThisSemester=" + waterNumberThisSemester + 
                ", paystatus=" + paystatus + ", status=" + status + ", type=" + type + '}';
    }
 
}
