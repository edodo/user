package user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import user.model.MemoEntity;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTest {
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            MemoEntity memoEntity = MemoEntity.builder()
                    .memoTitle("Title : " + i)
                    .memoText("text content " + i)
                    .build();
            memoRepository.save(memoEntity);
        });
    }

    @Test
    public void SelectDummies() {
        Long id = 9L;
        Optional<MemoEntity> result = memoRepository.findById(id);
        System.out.println("=======================");
        if(result.isPresent()) {
            MemoEntity memoEntity = result.get();
            System.out.println(memoEntity);
        }
    }

    @Test
    public void UpdateDummies() {
        MemoEntity memoEntity = MemoEntity.builder()
                .id(9L)
                .memoText("update Text 10")
                .build();
        memoRepository.save(memoEntity);
    }

    @Test
    public void DeleteDumies() {
        Long id = 10L;
        memoRepository.deleteById(id);
    }
}
