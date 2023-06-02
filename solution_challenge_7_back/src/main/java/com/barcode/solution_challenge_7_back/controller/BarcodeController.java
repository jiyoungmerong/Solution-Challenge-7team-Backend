package com.barcode.solution_challenge_7_back.controller;

import com.barcode.solution_challenge_7_back.domain.BarCode;
import com.barcode.solution_challenge_7_back.domain.dto.BarcodeDto;
import com.barcode.solution_challenge_7_back.exception.BarcodeNotFoundException;
import com.barcode.solution_challenge_7_back.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BarcodeController {
    private final BarcodeService barcodeService;

    @GetMapping("barcode/{barcodeNumber}")
    public BarcodeDto getBarcodeInfo(@PathVariable String barcodeNumber) {
        if(barcodeNumber == null){
            throw new BarcodeNotFoundException("바코드 번호를 찾을 수 없습니다.");
        }
        return barcodeService.getProductInfoByBarcode(barcodeNumber);
    }


    @GetMapping("/recycle/{material}")
    public ResponseEntity<String> getRecyclingInfo(@PathVariable String material){
        String recyclingInfo = null; // 분리수거 방법
        if (material.equals("vinyl")) { // 비닐
            recyclingInfo = "- 가정에서 배출된 재활용 폐기물은 지자체나 사업자가 운영하는 선별센터로 수집되어 폐기물의 상태나 재질에 따라 선별됩니다.\n" +
                    "- 이때 깨끗한 것들은 재활용이 되고, 오염된 플라스틱, 비닐과 같은 불에 타는 쓰레기, 가연성 폐기물은 압축되어 수도권매립지로 운송됩니다.\n" +
                    "- 반입된 폐기물은 크레인을 이용해 자동투입장치로 이동하며 파봉파쇄기를 통해 파쇄가 이루어집니다.\n" +
                    "- 파쇄가 완료된 비닐은 컨베이어를 통해 입자의 크기, 무게, 재질에 따른 분리, 선별 등의 과정을 거칩니다.\n" +
                    "- 선별된 비닐을 재질에 따라 용융압출, 용융성형, 압출성형, 열분해 및 냉각 등의 공정을 거쳐 재생원료, 재생제품, 재생 유류, 고형원료 등 을 생산합니다.";
        }
        else if(material.equals("styrofoam")){ // 스티로폼
            recyclingInfo = "- 회수된 스티로품을 분쇄합니다.\n" +
                    "- 분쇄된 스티로품은 경량콘크리트나 코팅제를 만드는데 사용되거나, 감용기를 이용해 녹여 재생원료인 잉코트로 만듭니다.\n" +
                    "- 이렇게 만들어진 앙코트는 해외로 수출되거나 압출기를 통해 또다른 재생원료인 펠릿을 만들어 새로운 재활용제품을 만드는데 사용됩니다.";
        }
        else if(material.equals("plastic")){ // 플라스틱
            recyclingInfo = "- 가정에서 배출된 재활용 폐기물은 지자체나 사업자가 운영하는 선별센터로 수집되어 폐기물의 상태나 재질에 따라 선별됩니다.\n" +
                    "- 이때 깨끗한 것들은 재활용이 되고, 오염된 플라스틱, 비닐과 같은 불에 타는 쓰레기, 가연성 폐기물은 압축되어 수도권매립지로 운송됩니다.\n" +
                    "- 반입된 폐기물은 크레인을 이용해 자동투입장치로 이동하며 파봉파쇄기를 통해 파쇄가 이루어집니다.\n" +
                    "- 파쇄가 완료된 폐기물은 컨베이어를 통해 입자의 크기, 무게, 재질에 따른 분리, 선별 등의 과정을 거칩니다.\n" +
                    "- 선별된 폐기물을 재질에 따라 용융압출, 용융성형, 압출성형, 열분해 및 냉각 등의 공정을 거쳐 재생원료, 재생제품, 재생 유류, 고형원료 등 을 생산합니다.";
        }

        else if(material.equals("glass")){ // 유리
            recyclingInfo = "- 분리배출 후 회수된 혼합 폐유리병은 색상 선별 라인 투입구에 투입됩니다.\n" +
                    "- 폐유리병 색상에 따라 백색, 갈색, 녹색으로 선별합니다.\n" +
                    "- 선별된 폐유리병을 파쇄합니다.\n" +
                    "- 파쇄된 유리에서 나온 이물질을 선별합니다.\n" +
                    "- 이때 도자기류 등 재활이 불가능한 이물질도 이때 선별됩니다.\n" +
                    "- 마그넷을 이용하여 뚜껑 등과 같은 금속류를 선별합니다.\n" +
                    "- 파쇄된 유리병을 가공하여 유리 재생원료를 생산합니다.\n" +
                    "- 이렇게 생산된 재생원료는 용융해 새로운 유리병을 생산하는데 쓰이거나 글라스비드, 글라스타일, 유리블록 등 다양한 제품의 원료로 사용됩니다.";
        }
        else if (material.equals("can")) { // 캔
            recyclingInfo = "- 분리배출된 캔들은 수거되어 재활용사업장 선별시설에 투입됩니다.\n"+
                    "- 투입된 캔들은 철캔과 알루미늄캔으로 선별합니다.\n"+
                    "- 선별된 철캔과 알루미늄캔을 각각 압축하여 압축물로 만듭니다.\n" +
                    "- 만들어진 압축물은 제철소 및 합금업체 등으로 이송됩니다.\n" +
                    "- 이송된 압축물들은 용광로 등에서 철, 알루미늄으로 생산됩니다.\n" +
                    "- 생산된 철과 알루미늄은 다시 제품생산 공장으로 돌아가 강판, 철근, 금속캔, 자동차부품 등으로 다시 사용됩니다.";

        }
        else if(material.equals("paper")){ // 종이
            recyclingInfo = "- 이물질 제거와 수집 원료로 쓰기 곤란한 원료 선별합니다.\n" +
                    "- 펄프와 비닐을 부드럽게 해리시켜 분리 시킵니다.\n"+
                    "- 가성소다를 투입하여 우유팩 인쇄잉크 및 불순물을 제거합니다.\n" +
                    "- 미해리 원료를 세밀하게 해리시킴과 동시에 미세하게 절단하고 해리되지 않은 섬유는 제거합니다.\n"+
                    "- 펄프화된 화장지 원료를 물에서 건져내 원지판에 묻혀 화장지의 원단이 되는 초지 완성합니다.\n"+
                    "- 이렇게 생산된 초지를 화장지 가공업체에서 무늬나 엠보싱 처리후 판매용 화장지로 포장합니다.";
        }

        if (recyclingInfo != null) {
            return ResponseEntity.ok(recyclingInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}