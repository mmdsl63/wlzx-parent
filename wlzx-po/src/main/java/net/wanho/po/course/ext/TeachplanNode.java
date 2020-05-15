package net.wanho.po.course.ext;


import net.wanho.po.course.Teachplan;
import lombok.Data;
import lombok.ToString;


import java.util.List;


@Data
@ToString
public class TeachplanNode extends Teachplan {
    List<TeachplanNode> children;
}
