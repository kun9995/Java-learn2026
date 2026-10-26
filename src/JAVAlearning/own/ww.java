package JAVAlearning.own;

public class ww

/**
 * 任务数据模型：每条任务包含内容、提醒时间和完成状态。
 */
 {
    private String content;     // 任务内容
    private String remindTime;  // 提醒时间，格式 "HH:mm"；为空表示不提醒
    private boolean done;       // 是否已完成

    public Task(String content, String remindTime, boolean done) {
        this.content = content;
        this.remindTime = remindTime;
        this.done = done;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * 判断当前时间(HH:mm)是否到达该任务的提醒时间点。
     */
    public boolean shouldRemind(String nowHHmm) {
        return remindTime != null && !remindTime.isEmpty()
                && remindTime.equals(nowHHmm) && !done;
    }

    /**
     * 列表展示用的文本：已完成的任务加一个勾选标记。
     */
    @Override
    public String toString() {
        String mark = done ? "[√] " : "[ ] ";
        String time = (remindTime == null || remindTime.isEmpty())
                ? "" : " (" + remindTime + ")";
        return mark + content + time;
    }
}

